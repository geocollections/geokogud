package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;
import ee.ttu.geocollection.interop.api.localities.service.LocalitiesApiService;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
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
public class LocalityIndexServiceImpl extends AbstractIndexingService<LocalitySearchCriteria> {

    @Autowired
    private DirectoryReader localityDirectoryReader;
    @Autowired
    private IndexWriter localityDirectoryWriter;
    @Autowired
    private TechnicalIndexService technicalIndexService;
    @Autowired
    private LocalitiesApiService localitiesApiService;

    @Override
    protected void createIndices() {
        LocalitySearchCriteria localitySearchCriteria = new LocalitySearchCriteria();
        localitySearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createIndicesFromScratch(
                technicalIndexService,
                localityDirectoryWriter,
                localitySearchCriteria,
                (searchCriteria) -> localitiesApiService.findLocalitiesForIndex(searchCriteria));
    }

    @Override
    protected void updateIndices() {
        LocalitySearchCriteria updateSearchCriteria = new LocalitySearchCriteria();
        updateSearchCriteria.setSortField(new SortField(DATE_CHANGED, SortingOrder.DESCENDING));
        updateOldIndices(
                updateSearchCriteria,
                (searchCriteria) -> localitiesApiService.findLocalitiesForIndex(searchCriteria),
                localityDirectoryWriter,
                localityDirectoryReader,
                technicalIndexService);

        LocalitySearchCriteria createSearchCriteria = new LocalitySearchCriteria();
        createSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createMissingIndices(
                createSearchCriteria,
                (searchCriteria) -> localitiesApiService.findLocalitiesForIndex(searchCriteria),
                localityDirectoryWriter,
                localityDirectoryReader,
                technicalIndexService);
    }

    @Override
    public Document buildDocument(Map<String, Object> entry) {
        Long idLong = Long.valueOf(entry.get(ID).toString());

        Document document = DocumentBuilder.aDocument()
                .targetEntry(entry)
                .withField(ID, StringField.TYPE_STORED)
                .withField(NUMBER, StringField.TYPE_NOT_STORED)
                .withField(LOCALITYSYNONYM_SYNONYM, TextField.TYPE_NOT_STORED)
                .withField(LOCALITY, TextField.TYPE_NOT_STORED)
                .withField(LOCALITY_ENG, TextField.TYPE_NOT_STORED)
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
                        .appendParameter(NUMBER, DataType.STRING)
                        .appendParameter(LOCALITYSYNONYM_SYNONYM, DataType.TEXT)
                        .appendParameter(LOCALITY, DataType.TEXT)
                        .appendParameter(LOCALITY_ENG, DataType.TEXT),
                localityDirectoryReader);
        return documents.isEmpty() ?
                new ApiResponse() :
                localitiesApiService.findLocalitiesByIds(
                        documents.stream()
                                .map(document -> document.get(ID))
                                .collect(toList()));
    }
}
