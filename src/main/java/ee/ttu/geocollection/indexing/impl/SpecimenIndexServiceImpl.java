package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geocollection.interop.api.specimen.service.SpecimenApiService;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

import static ee.ttu.geocollection.indexing.GlobalSearchConstants.ID_LONG;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
import static java.util.stream.Collectors.toList;

@Service
public class SpecimenIndexServiceImpl extends AbstractIndexingService<SpecimenSearchCriteria> {
    @Value("${globalSearch.recreateIndices}")
    private boolean recreateIndices;

    @Autowired
    private DirectoryReader specimenDirectoryReader;
    @Autowired
    private IndexWriter specimenDirectoryWriter;
    @Autowired
    private TechnicalIndexService technicalIndexService;
    @Autowired
    private SpecimenApiService specimenApiService;

    @Override
    protected void createIndices() {
        SpecimenSearchCriteria sampleSearchCriteria = new SpecimenSearchCriteria();
        sampleSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createIndicesFromScratch(
                technicalIndexService,
                specimenDirectoryWriter,
                sampleSearchCriteria,
                (searchCriteria) -> specimenApiService.findSpecimensForIndex(searchCriteria));
    }

    @Override
    protected void updateIndices() {
        SpecimenSearchCriteria updateSearchCriteria = new SpecimenSearchCriteria();
        updateSearchCriteria.setSortField(new SortField(DATE_CHANGED, SortingOrder.DESCENDING));
        updateOldIndices(
                updateSearchCriteria,
                (searchCriteria) -> specimenApiService.findSpecimensForIndex(searchCriteria),
                specimenDirectoryWriter,
                specimenDirectoryReader,
                technicalIndexService);

        SpecimenSearchCriteria createSearchCriteria = new SpecimenSearchCriteria();
        createSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createMissingIndices(
                createSearchCriteria,
                (searchCriteria) -> specimenApiService.findSpecimensForIndex(searchCriteria),
                specimenDirectoryWriter,
                specimenDirectoryReader,
                technicalIndexService);
    }

    @Override
    public ApiResponse searchInIndex(String value) {
        Collection<Document> documents = technicalIndexService.searchInIndex(
                QueryParameters.params()
                        .queryValue(value)
                        .appendParameter(ID, DataType.NUMERIC)
                        .appendParameter(SPECIMEN_NR, DataType.STRING)
                        .appendParameter(SPECIMEN_ID, DataType.STRING)
                        .appendParameter(CLASSIFICATION__CLASS_FIELD, DataType.TEXT)
                        .appendParameter(CLASSIFICATION__CLASS_EN, DataType.TEXT)
                        .appendParameter(SPECIMENIDENTIFICATION__NAME, DataType.TEXT)
                        .appendParameter(SPECIMENIDENTIFICATION__TAXON__TAXON, DataType.TEXT),
                specimenDirectoryReader);
        return documents.isEmpty() ?
                new ApiResponse() :
                specimenApiService.findSpecimensByIds(
                        documents.stream()
                                .map(document -> document.get(ID))
                                .collect(toList()));
    }

    @Override
    protected Document buildDocument(Map<String, Object> entry) {
        Long idLong = Long.valueOf(entry.get(ID).toString());

        Document document = DocumentBuilder.aDocument()
                .targetEntry(entry)
                .withField(ID, StringField.TYPE_STORED)
                .withField(SPECIMEN_NR, StringField.TYPE_NOT_STORED)
                .withField(SPECIMEN_ID, StringField.TYPE_NOT_STORED)
                .withField(CLASSIFICATION__CLASS_FIELD, TextField.TYPE_NOT_STORED)
                .withField(CLASSIFICATION__CLASS_EN, TextField.TYPE_NOT_STORED)
                .withField(SPECIMENIDENTIFICATION__NAME, TextField.TYPE_NOT_STORED)
                .withField(SPECIMENIDENTIFICATION__TAXON__TAXON, TextField.TYPE_NOT_STORED)
                .withField(DATE_CHANGED, StringField.TYPE_STORED)
                .build();
        document.add(new LongPoint(ID_LONG, idLong));

        return document;
    }
}
