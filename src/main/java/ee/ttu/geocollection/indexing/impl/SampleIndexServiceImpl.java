package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.IndexService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

import static ee.ttu.geocollection.indexing.GlobalSearchConstants.ID_LONG;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

@Service
public class SampleIndexServiceImpl implements IndexService<SampleSearchCriteria> {
    @Autowired
    private DirectoryReader sampleDirectoryReader;
    @Autowired
    private IndexWriter sampleDirectoryWriter;

    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private TechnicalIndexService technicalIndexService;

    @Override
    public void createIndex() {
        SampleSearchCriteria sampleSearchCriteria = new SampleSearchCriteria();
        sampleSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createIndexInternally(
                technicalIndexService,
                sampleDirectoryWriter,
                sampleSearchCriteria,
                (searchCriteria) -> samplesApiService.findSampleForIndex(searchCriteria));
    }


    @Override
    public Document buildDocument(Map<String, Object> entry) {
        Long idLong = Long.valueOf(entry.get(ID).toString());

        Document document = DocumentBuilder.aDocument()
                .targetEntry(entry)
                .withField(ID, StringField.TYPE_STORED)
                .withField(NUMBER, StringField.TYPE_NOT_STORED)
                .withField(NUMBER_ADDITIONAL, StringField.TYPE_NOT_STORED)
                .withField(LOCALITY_LOCALITY, TextField.TYPE_NOT_STORED)
                .withField(DATE_CHANGED, StoredField.TYPE)
                .build();
        document.add(new LongPoint(ID_LONG, idLong));

        return document;
    }

    @Override
    public Collection<Document> searchInIndex() {
        Collection<Document> documents = technicalIndexService.searchInIndex(
                QueryParameters.params()
                        .queryValue("puurauk".toLowerCase())
                        .appendParameter(ID, DataType.NUMERIC)
                        .appendParameter(NUMBER, DataType.STRING)
                        .appendParameter(NUMBER_FIELD, DataType.STRING)
                        .appendParameter(LOCALITY_LOCALITY, DataType.TEXT)
                        .appendParameter(LOCALITY_LOCALITY_EN, DataType.TEXT),
                sampleDirectoryReader);
        return documents;
    }
}
