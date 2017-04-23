package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.IndexService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geocollection.interop.api.specimen.service.SpecimenApiService;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

import static ee.ttu.geocollection.ProfileConstants.INDEXING_ENABLED;
import static ee.ttu.geocollection.indexing.GlobalSearchConstants.ID_LONG;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

@Service
@Profile(INDEXING_ENABLED)
public class SpecimenIndexServiceImpl implements IndexService<SpecimenSearchCriteria> {
    @Autowired
    private DirectoryReader specimenDirectoryReader;
    @Autowired
    private IndexWriter specimenDirectoryWriter;

    @Autowired
    private SpecimenApiService specimenApiService;
    @Autowired
    private TechnicalIndexService technicalIndexService;

    @Override
    @Async(value = "asyncThreadPoolExecutor")
    public void createIndex() {
        SpecimenSearchCriteria sampleSearchCriteria = new SpecimenSearchCriteria();
        sampleSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createIndexInternally(
                technicalIndexService,
                specimenDirectoryWriter,
                sampleSearchCriteria,
                (searchCriteria) -> specimenApiService.findSpecimensForIndex(searchCriteria));
    }

    @Override
    public Collection<Document> searchInIndex(String value) {
        Collection<Document> documents = technicalIndexService.searchInIndex(
                QueryParameters.params()
                        .queryValue(value.toLowerCase())
                        .appendParameter(ID, DataType.NUMERIC)
                        .appendParameter(SPECIMEN_NR, DataType.STRING)
                        .appendParameter(SPECIMEN_ID, DataType.STRING)
                        .appendParameter(CLASSIFICATION__CLASS_FIELD, DataType.TEXT)
                        .appendParameter(CLASSIFICATION__CLASS_EN, DataType.TEXT)
                        .appendParameter(SPECIMENIDENTIFICATION__NAME, DataType.TEXT)
                        .appendParameter(SPECIMENIDENTIFICATION__TAXON__TAXON, DataType.TEXT),
                specimenDirectoryReader);
        return documents;
    }

    @Override
    public Document buildDocument(Map<String, Object> entry) {
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
                .withField(DATE_CHANGED, StoredField.TYPE)
                .build();
        document.add(new LongPoint(ID_LONG, idLong));

        return document;
    }
}
