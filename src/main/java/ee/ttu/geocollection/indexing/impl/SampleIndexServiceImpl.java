package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
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
public class SampleIndexServiceImpl extends AbstractIndexingService<SampleSearchCriteria> {

    @Autowired
    private DirectoryReader sampleDirectoryReader;
    @Autowired
    private IndexWriter sampleDirectoryWriter;
    @Autowired
    private TechnicalIndexService technicalIndexService;
    @Autowired
    private SamplesApiService samplesApiService;

    @Override
    protected void updateIndex() {
        SampleSearchCriteria updateSearchCriteria = new SampleSearchCriteria();
        updateSearchCriteria.setSortField(new SortField(DATE_CHANGED, SortingOrder.DESCENDING));
        updateOldIndices(
                updateSearchCriteria,
                (searchCriteria) -> samplesApiService.findSampleForIndex(searchCriteria),
                sampleDirectoryWriter,
                sampleDirectoryReader,
                technicalIndexService);
        }

    @Override
    protected void createIndex() {
        SampleSearchCriteria createSearchCriteria = new SampleSearchCriteria();
        createSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createMissingIndices(
                createSearchCriteria,
                (searchCriteria) -> samplesApiService.findSampleForIndex(searchCriteria),
                sampleDirectoryWriter,
                sampleDirectoryReader,
                technicalIndexService);
    }

    @Override
    protected Document buildDocument(Map<String, Object> entry) {
        Long idLong = Long.valueOf(entry.get(ID).toString());

        Document document = DocumentBuilder.aDocument()
                .targetEntry(entry)
                .withField(ID, StringField.TYPE_STORED)
                .withField(NUMBER, StringField.TYPE_NOT_STORED)
                .withField(NUMBER_ADDITIONAL, StringField.TYPE_NOT_STORED)
                .withField(LOCALITY_LOCALITY, TextField.TYPE_NOT_STORED)
                .withField(LOCALITY_LOCALITY_EN, TextField.TYPE_NOT_STORED)
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
                        .appendParameter(NUMBER_ADDITIONAL, DataType.STRING)
                        .appendParameter(LOCALITY_LOCALITY, DataType.TEXT)
                        .appendParameter(LOCALITY_LOCALITY_EN, DataType.TEXT),
                sampleDirectoryReader);
        return documents.isEmpty() ?
                new ApiResponse() :
                samplesApiService.findSamplesByIds(
                        documents.stream()
                                .map(document -> document.get(ID))
                                .collect(toList()));
    }
}