package ee.ttu.geocollection.interop.api.global.impl;

import ee.ttu.geocollection.domain.LookUpType;
import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.global.DataType;
import ee.ttu.geocollection.interop.api.global.IndexService;
import ee.ttu.geocollection.interop.api.global.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.global.domain.DocumentBuilder;
import ee.ttu.geocollection.interop.api.global.domain.QueryParameters;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import org.apache.lucene.document.*;
import org.apache.lucene.store.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
import static java.util.stream.Collectors.toList;

@Service
public class SampleIndexServiceImpl implements IndexService {
    private static final String ID_LONG = "idLong";

    @Autowired
    private Directory sampleDirectory;
    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private TechnicalIndexService technicalIndexService;

    @Override
    public void createIndex() {
        SampleSearchCriteria sampleSearchCriteria = new SampleSearchCriteria();
        sampleSearchCriteria.setId(new SearchField("250", LookUpType.lt));
        sampleSearchCriteria.setSortField(new SortField());

        ApiResponse samples = samplesApiService.findSample(sampleSearchCriteria);

        technicalIndexService.createIndex(
                samples.getResult().stream().map(this::buildDocument).collect(toList()),
                sampleDirectory);
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
                        .queryValue("puurauk")
                        .appendParameter(ID, DataType.NUMERIC)
                        .appendParameter(NUMBER, DataType.STRING)
                        .appendParameter(NUMBER_FIELD, DataType.STRING)
                        .appendParameter(LOCALITY_LOCALITY, DataType.TEXT)
                        .appendParameter(LOCALITY_LOCALITY_EN, DataType.TEXT),
                sampleDirectory);
        return documents;
    }
}
