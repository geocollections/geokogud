package ee.ttu.geocollection.indexing.technical.tasks;

import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.IndexingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexingTaskService {
    @Autowired
    private IndexingProperties indexingProperties;
    @Autowired
    private List<AbstractIndexingService> abstractIndexingServices;

    /**
     * Task is executed every 1H, indexing is performed only when globalSearch.indexing flag in properties file is set to true
     */
    @Scheduled(initialDelay = 1500, fixedRate = 3600000)
    public void createIndices() {
        if(indexingProperties.isIndexingEnabled()) {
            abstractIndexingServices.forEach(AbstractIndexingService::createUpdateIndex);
        }
    }
}