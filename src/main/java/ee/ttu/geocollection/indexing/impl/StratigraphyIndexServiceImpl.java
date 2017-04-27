package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;
import ee.ttu.geocollection.interop.api.stratigraphies.service.StratigraphyApiService;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

import static ee.ttu.geocollection.indexing.GlobalSearchConstants.ID_LONG;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
import static java.util.stream.Collectors.toList;

@Service
public class StratigraphyIndexServiceImpl extends AbstractIndexingService<StratigraphySearchCriteria> {

    @Autowired
    private DirectoryReader stratigraphyDirectoryReader;
    @Autowired
    private IndexWriter stratigraphyDirectoryWriter;
    @Autowired
    private TechnicalIndexService technicalIndexService;
    @Autowired
    private StratigraphyApiService stratigraphyApiService;

    @Override
    protected void createIndices() {
        StratigraphySearchCriteria stratigraphySearchCriteria = new StratigraphySearchCriteria();
        stratigraphySearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createIndicesFromScratch(
                technicalIndexService,
                stratigraphyDirectoryWriter,
                stratigraphySearchCriteria,
                (searchCriteria) -> stratigraphyApiService.findStratigraphyForIndex(searchCriteria));
    }

    @Override
    protected void updateIndices() {
        StratigraphySearchCriteria updateSearchCriteria = new StratigraphySearchCriteria();
        updateSearchCriteria.setSortField(new SortField(DATE_CHANGED, SortingOrder.DESCENDING));
        updateOldIndices(
                updateSearchCriteria,
                (searchCriteria) -> stratigraphyApiService.findStratigraphyForIndex(searchCriteria),
                stratigraphyDirectoryWriter,
                stratigraphyDirectoryReader,
                technicalIndexService);

        StratigraphySearchCriteria createSearchCriteria = new StratigraphySearchCriteria();
        createSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createMissingIndices(
                createSearchCriteria,
                (searchCriteria) -> stratigraphyApiService.findStratigraphyForIndex(searchCriteria),
                stratigraphyDirectoryWriter,
                stratigraphyDirectoryReader,
                technicalIndexService);
    }

    @Override
    public Document buildDocument(Map<String, Object> entry) {
        Long idLong = Long.valueOf(entry.get(ID).toString());

        Document document = DocumentBuilder.aDocument()
                .targetEntry(entry)
                .withField(ID, StringField.TYPE_STORED)
                .withField(STRATIGRAPHY, StringField.TYPE_NOT_STORED)
                .withField(STRATIGRAPHY_EN, StringField.TYPE_NOT_STORED)
                .withField(INDEX_MAIN, StringField.TYPE_NOT_STORED)
                .withField(INDEX_ADDITIONAL, StringField.TYPE_NOT_STORED)
                .withField(PARENT_STRATIGRAPHY, StringField.TYPE_NOT_STORED)
                .withField(PARENT_STRATIGRAPHY_EN, StringField.TYPE_NOT_STORED)
                .withField(AGE_CHRONOSTRATIGRAPHY_STRATIGRAPHY, StringField.TYPE_NOT_STORED)
                .withField(AGE_CHRONOSTRATIGRAPHY_STRATIGRAPHY_EN, StringField.TYPE_NOT_STORED)
                .withField(DATE_CHANGED, StringField.TYPE_STORED)
                .build();
        document.add(new LongPoint(ID_LONG, idLong));

        return document;
    }

    @Override
    public ApiResponse searchInIndex(String value) {
        Collection<Document> documents = technicalIndexService.searchInIndex(
                QueryParameters.params()
                        .queryValue(value)
                        .appendParameter(ID, DataType.NUMERIC)
                        .appendParameter(STRATIGRAPHY, DataType.STRING)
                        .appendParameter(STRATIGRAPHY_EN, DataType.STRING)
                        .appendParameter(INDEX_MAIN, DataType.STRING)
                        .appendParameter(INDEX_ADDITIONAL, DataType.STRING)
                        .appendParameter(PARENT_STRATIGRAPHY, DataType.STRING)
                        .appendParameter(PARENT_STRATIGRAPHY_EN, DataType.STRING)
                        .appendParameter(AGE_CHRONOSTRATIGRAPHY_STRATIGRAPHY, DataType.STRING)
                        .appendParameter(AGE_CHRONOSTRATIGRAPHY_STRATIGRAPHY_EN, DataType.STRING),
                stratigraphyDirectoryReader);
        return documents.isEmpty() ?
                new ApiResponse() :
                stratigraphyApiService.findStratigraphyByIds(
                        documents.stream()
                                .map(document -> document.get(ID))
                                .collect(toList()));
    }
}
