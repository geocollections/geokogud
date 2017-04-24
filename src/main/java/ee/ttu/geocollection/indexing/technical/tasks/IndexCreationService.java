package ee.ttu.geocollection.indexing.technical.tasks;

import ee.ttu.geocollection.indexing.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexCreationService {
    @Autowired
    private List<IndexService> indexServices;

    /**
     * Executed only once only if indices recreation is required
     */
    @Scheduled(initialDelay = 1500, fixedRate = Long.MAX_VALUE)
    public void createIndices() {
        indexServices.forEach(IndexService::createUpdateIndex);
    }
}