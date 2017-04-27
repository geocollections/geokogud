package ee.ttu.geocollection.indexing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IndexingProperties {
    @Value("${globalSearch.batchSize}")
    private int indexingBatchSize;
    @Value("${globalSearch.indexing}")
    private boolean indexingEnabled;

    public int getIndexingBatchSize() {
        return indexingBatchSize;
    }

    public boolean isIndexingEnabled() {
        return indexingEnabled;
    }
}
