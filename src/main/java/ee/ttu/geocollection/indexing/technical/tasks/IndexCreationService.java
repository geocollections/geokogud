package ee.ttu.geocollection.indexing.technical.tasks;

import ee.ttu.geocollection.indexing.AbstractIndexingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexCreationService {
    @Value("${globalSearch.indexing}")
    private boolean indexing;

    @Autowired
    private List<AbstractIndexingService> abstractIndexingServices;

    /**
     * Task is executed every 24H, indexing is performed only when appropriate flag is set to true
     */
    @Scheduled(initialDelay = 1500, fixedRate = 86400000)
    public void createIndices() {
        if(indexing) {
            abstractIndexingServices.forEach(AbstractIndexingService::createUpdateIndex);
        }
    }
}