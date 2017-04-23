package ee.ttu.geocollection.interop.api.global.impl;

import ee.ttu.geocollection.domain.LookUpType;
import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.global.DataType;
import ee.ttu.geocollection.interop.api.global.IndexService;
import ee.ttu.geocollection.interop.api.global.QueryParameters;
import ee.ttu.geocollection.interop.api.global.TechnicalIndexService;
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
    public static final String ID_STRING = "idString";

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

        technicalIndexService.createIndex(samples.getResult().stream().map(this::buildDocument).collect(toList()), sampleDirectory);
    }


    @Override
    public Document buildDocument(Map<String, Object> entry) {
        Document document = new Document();
        Long idLong = Long.valueOf(entry.get(ID).toString());

        LongPoint id = new LongPoint(ID, idLong);
        document.add(id);

        Object dateChanged = entry.get(DATE_CHANGED);
        if (dateChanged != null) {
            StoredField dateChangedStored = new StoredField(DATE_CHANGED, dateChanged.toString());
            document.add(dateChangedStored);
        }

        //i am forced to use here stringfield because there might be special characters in the number: M-14 and textfield cannot handle them
        StringField number = new StringField(NUMBER, ((String) entry.get(NUMBER)).toLowerCase(), Field.Store.NO);
        document.add(number);

        String numberAdditional = (String) entry.get(NUMBER_ADDITIONAL);
        if (numberAdditional != null) {
            StringField numberAdditionalField = new StringField(NUMBER_ADDITIONAL, numberAdditional.toLowerCase(), Field.Store.NO);
            document.add(numberAdditionalField);
        }

        String locality = (String) entry.get(LOCALITY_LOCALITY);
        if (locality != null) {
            TextField localityField = new TextField(LOCALITY_LOCALITY, locality, Field.Store.NO);
            document.add(localityField);
        }

        StringField idField = new StringField(ID_STRING, idLong.toString(), Field.Store.YES);
        document.add(idField);
        return document;
    }

    @Override
    public Collection<Document> searchInIndex() {
        Collection<Document> documents = technicalIndexService.searchInIndex(
                QueryParameters.params()
                        .queryValue("-14")
                        .appendParameter(ID_STRING, DataType.NUMERIC)
                        .appendParameter(NUMBER, DataType.STRING)
                        .appendParameter(NUMBER_FIELD, DataType.STRING)
                        .appendParameter(LOCALITY_LOCALITY, DataType.TEXT)
                        .appendParameter(LOCALITY_LOCALITY_EN, DataType.TEXT),
                sampleDirectory);

        return documents;
    }
}
