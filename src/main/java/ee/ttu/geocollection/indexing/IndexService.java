package ee.ttu.geocollection.indexing;

import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.PageableSearchCriteria;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

import static ee.ttu.geocollection.EnvironmentConstants.PRODUCTION;
import static java.util.stream.Collectors.toList;

@Profile(PRODUCTION)
public interface IndexService<T extends PageableSearchCriteria> {
    @Async(value = "asyncThreadPoolExecutor")
    void createIndex();

    default void createIndexInternally(
            TechnicalIndexService technicalIndexService,
            IndexWriter indexWriter,
            T searchCriteria,
            Function<T, ApiResponse> apiCall) {

        int currentPage = 1;
        int lastPage = 1;
        while(currentPage <= lastPage) {
            searchCriteria.setPage(currentPage);
            ApiResponse samplesForIndex = apiCall.apply(searchCriteria);
            currentPage++;
            if(lastPage == 1) {
                lastPage = samplesForIndex.extractLastPageNumber();
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            technicalIndexService.createIndex(
                    samplesForIndex.getResult().stream().map(this::buildDocument).collect(toList()),
                    indexWriter);
        }
    }

    Document buildDocument(Map<String, Object> entry);

    Collection<Document> searchInIndex();
}
