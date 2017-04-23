package ee.ttu.geocollection.interop.api.global.update;

import ee.ttu.geocollection.interop.api.global.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexUpdateService {
    @Autowired
    private List<IndexService> indexServices;

    @Scheduled(initialDelay = 1000, fixedRate = 300000000)
    public void updateIndexes() {
        indexServices.forEach(IndexService::createIndex);
    }
}