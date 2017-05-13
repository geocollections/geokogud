package ee.ttu.geocollection.indexing;

import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.PageableSearchCriteria;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static ee.ttu.geocollection.indexing.technical.utils.IndexUtils.createDirectoryReader;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.DATE_CHANGED;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.ID;
import static java.util.stream.Collectors.toList;

public abstract class AbstractIndexingService<T extends PageableSearchCriteria> {
    @Value("${globalSearch.recreateIndices}")
    private boolean recreateIndices;

    @Async(value = "asyncThreadPoolExecutor")
    public void createUpdateIndex() {
        updateIndex();
        createIndex();
    }

    protected abstract void updateIndex();

    protected abstract void createIndex();

    protected abstract Document buildDocument(Map<String, Object> entry);

    public abstract ApiResponse searchInIndex(String value);

    protected void createMissingIndices(
            T searchCriteria,
            Function<T, ApiResponse> apiCall,
            IndexWriter indexWriter,
            DirectoryReader directoryReader,
            TechnicalIndexService technicalIndexService) {
        int currentPage = 1;
        int lastPage = 1;
        while (currentPage <= lastPage) {
            searchCriteria.setPage(currentPage);
            ApiResponse samplesForIndex = apiCall.apply(searchCriteria);
            currentPage++;
            if (lastPage == 1) {
                lastPage = samplesForIndex.extractLastPageNumber();
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DirectoryReader refreshedDirectoryReader = createDirectoryReader(directoryReader);
            List<Document> documentsToCreate = samplesForIndex.getResult().stream()
                    .filter(entry -> documentNotPresentInIndex(entry, refreshedDirectoryReader))
                    .map(this::buildDocument)
                    .collect(toList());
            if (documentsToCreate.isEmpty()) {
                break;
            }
            technicalIndexService.createIndex(documentsToCreate, indexWriter);
            throw new RuntimeException();
        }
    }

    private boolean documentNotPresentInIndex(Map<String, Object> entry, DirectoryReader directoryReader) {
        try {
            Optional<ScoreDoc> documentId = lookupForDocumentById(entry, directoryReader);
            return !documentId.isPresent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<ScoreDoc> lookupForDocumentById(Map<String, Object> entry, IndexReader sampleDirectoryReaderLocal) throws IOException {
        IndexSearcher indexSearcher = new IndexSearcher(sampleDirectoryReaderLocal);

        Query query = new TermQuery(new Term(ID, entry.get(ID).toString()));
        TopDocs topDocs = indexSearcher.search(query, 1);
        ScoreDoc[] scoreDoc = topDocs.scoreDocs;
        return Stream.of(scoreDoc).findFirst();
    }


    protected void updateOldIndices(T searchCriteria, Function<T, ApiResponse> apiCall, IndexWriter indexWriter, DirectoryReader directoryReader, TechnicalIndexService technicalIndexService) {
        //1st type of updating: updating last changed entries
        //TODO implement also adding newly added indices (get entries sorted by ID in descending order and check indices)
        int currentPage = 1;
        while (true) {
            searchCriteria.setPage(currentPage);
            ApiResponse samplesForIndex = apiCall.apply(searchCriteria);
            currentPage++;
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DirectoryReader refreshedDirectoryReader = createDirectoryReader(directoryReader);
            List<Document> documentsToUpdate = samplesForIndex.getResult().stream()
                    .filter(entry -> indexRequiresUpdate(entry, refreshedDirectoryReader))
                    .map(this::buildDocument)
                    .collect(toList());
            if (documentsToUpdate.isEmpty()) {
                break;
            }
            technicalIndexService.updateIndex(documentsToUpdate, indexWriter);
        }
    }

    private boolean indexRequiresUpdate(Map<String, Object> entry, DirectoryReader directoryReader) {
        try {
            //TODO fix these hacks
            Optional<ScoreDoc> documentId = lookupForDocumentById(entry, directoryReader);
            if (documentId.isPresent()) {
                Document storedDocument = directoryReader.document(documentId.get().doc);
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
}
