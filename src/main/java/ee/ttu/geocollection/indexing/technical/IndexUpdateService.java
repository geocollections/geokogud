package ee.ttu.geocollection.indexing.technical;

import ee.ttu.geocollection.indexing.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static ee.ttu.geocollection.ProfileConstants.INDEXING_ENABLED;

@Service
@Profile(INDEXING_ENABLED)
public class IndexUpdateService {
    @Autowired
    private List<IndexService> indexServices;

    @Scheduled(initialDelay = 1000, fixedRate = 300000000)
    public void updateIndexes() {
        indexServices.forEach(IndexService::createIndex);
    }
}
