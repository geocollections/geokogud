package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.IndexService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static ee.ttu.geocollection.indexing.GlobalSearchConstants.ID_LONG;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
import static java.util.stream.Collectors.toList;

@Service
public class SampleIndexServiceImpl implements IndexService<SampleSearchCriteria> {
    @Value("${globalSearch.recreateIndices}")
    private boolean recreateIndices;

    @Autowired
    private DirectoryReader sampleDirectoryReader;
    @Autowired
    private IndexWriter sampleDirectoryWriter;

    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private TechnicalIndexService technicalIndexService;

    @Override
    public void createUpdateIndex() {
        if (recreateIndices) {
            SampleSearchCriteria sampleSearchCriteria = new SampleSearchCriteria();
            sampleSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
            createIndexInternally(
                    technicalIndexService,
                    sampleDirectoryWriter,
                    sampleSearchCriteria,
                    (searchCriteria) -> samplesApiService.findSampleForIndex(searchCriteria));
        } else {
            updateDocuments();
            createDocuments();
        }
    }

    private void createDocuments() {
        SampleSearchCriteria searchCriteria = new SampleSearchCriteria();
        searchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));

        int currentPage = 1;
        int lastPage = 1;
        while (currentPage <= lastPage) {
            searchCriteria.setPage(currentPage);
            ApiResponse samplesForIndex = samplesApiService.findSampleForIndex(searchCriteria);
            currentPage++;
            if (lastPage == 1) {
                lastPage = samplesForIndex.extractLastPageNumber();
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<Document> documentsToCreate = samplesForIndex.getResult().stream()
                    .filter(this::documentNotPresentInIndex)
                    .map(this::buildDocument)
                    .collect(toList());
            if (documentsToCreate.isEmpty()) {
                break;
            }
            technicalIndexService.createIndex(documentsToCreate, sampleDirectoryWriter);
        }
    }

    private boolean documentNotPresentInIndex(Map<String, Object> entry) {
        try {
            //TODO fix these hacks
            IndexReader sampleDirectoryReaderLocal = sampleDirectoryReader;
            DirectoryReader indexReaderUpdated = DirectoryReader.openIfChanged(sampleDirectoryReader);
            if (indexReaderUpdated != null) {
                sampleDirectoryReaderLocal = indexReaderUpdated;
            }
            Optional<ScoreDoc> documentId = lookupForDocumentById(entry, sampleDirectoryReaderLocal);
            return !documentId.isPresent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateDocuments() {
        SampleSearchCriteria searchCriteria = new SampleSearchCriteria();
        searchCriteria.setSortField(new SortField(DATE_CHANGED, SortingOrder.DESCENDING));
        //1st type of updating: updating last changed entries
        //TODO implement also adding newly added indices (get entries sorted by ID in descending order and check indices)
        int currentPage = 1;
        while (true) {
            searchCriteria.setPage(currentPage);
            ApiResponse samplesForIndex = samplesApiService.findSampleForIndex(searchCriteria);
            currentPage++;
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<Document> documentsToUpdate = samplesForIndex.getResult().stream()
                    .filter(this::indexRequiresUpdate)
                    .map(this::buildDocument)
                    .collect(toList());
            if (documentsToUpdate.isEmpty()) {
                break;
            }
            technicalIndexService.updateIndex(documentsToUpdate, sampleDirectoryWriter);
        }
    }

    private boolean indexRequiresUpdate(Map<String, Object> entry) {
        try {
            //TODO fix these hacks
            IndexReader sampleDirectoryReaderLocal = sampleDirectoryReader;
            DirectoryReader indexReaderUpdated = DirectoryReader.openIfChanged(sampleDirectoryReader);
            if (indexReaderUpdated != null) {
                sampleDirectoryReaderLocal = indexReaderUpdated;
            }
            Optional<ScoreDoc> documentId = lookupForDocumentById(entry, sampleDirectoryReaderLocal);
            if (documentId.isPresent()) {
                Document storedDocument = sampleDirectoryReaderLocal.document(documentId.get().doc);
                String storedDocumentDateChanged = storedDocument.get(DATE_CHANGED);
                if (!StringUtils.equalsIgnoreCase(storedDocumentDateChanged, (String) entry.get(DATE_CHANGED))) {
                    return true;
                }
            } else {
                //do nothing, will anyway get added in another block
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private Optional<ScoreDoc> lookupForDocumentById(Map<String, Object> entry, IndexReader sampleDirectoryReaderLocal) throws IOException {
        IndexSearcher indexSearcher = new IndexSearcher(sampleDirectoryReaderLocal);

        Query query = new TermQuery(new Term(ID, entry.get(ID).toString()));
        TopDocs topDocs = indexSearcher.search(query, 1);
        ScoreDoc[] scoreDoc = topDocs.scoreDocs;
        return Stream.of(scoreDoc).findFirst();
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
                .withField(LOCALITY_LOCALITY_EN, TextField.TYPE_NOT_STORED)
                .withField(DATE_CHANGED, StringField.TYPE_STORED)
                .build();
        document.add(new LongPoint(ID_LONG, idLong));

        return document;
    }

    @Override
    public List<Map> searchInIndex(String value) {
        Collection<Document> documents = technicalIndexService.searchInIndex(
                QueryParameters.params()
                        .queryValue(value)
                        .appendParameter(ID, DataType.NUMERIC)
                        .appendParameter(NUMBER, DataType.STRING)
                        .appendParameter(NUMBER_ADDITIONAL, DataType.STRING)
                        .appendParameter(LOCALITY_LOCALITY, DataType.TEXT)
                        .appendParameter(LOCALITY_LOCALITY_EN, DataType.TEXT),
                sampleDirectoryReader);
        return documents.stream()
                .map(document -> document.get(ID))
                .map(id -> samplesApiService.findRawById(Long.valueOf(id)))
                .collect(toList());
    }
}