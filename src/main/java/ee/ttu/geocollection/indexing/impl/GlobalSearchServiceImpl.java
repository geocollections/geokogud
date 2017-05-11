package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.core.domain.AppConfig;
import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.GlobalSearchService;
import ee.ttu.geocollection.indexing.IndexingProperties;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {

    @Autowired
    private IndexingProperties indexingProperties;
    @Autowired
    private AppConfig appConfig;

    @Autowired
    private List<AbstractIndexingService> indexServices;

    @Override
    public Iterable searchGlobally(String query) {
        if (indexingProperties.isIndexingEnabled()) {
            return Observable.fromIterable(indexServices)
                    .flatMap(abstractIndexingService ->
                            Observable.fromCallable(() -> abstractIndexingService.searchInIndex(query)))
                    .timeout(appConfig.asynchGlobalSearchTimeoutMillisecs, TimeUnit.MILLISECONDS)
                    .onErrorResumeNext(Observable.empty())
                    .subscribeOn(Schedulers.io())
                    .blockingIterable();
        }
        return new ArrayList<>();
    }
}