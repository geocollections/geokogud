package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.indexing.GlobalSearchService;
import ee.ttu.geocollection.indexing.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ee.ttu.geocollection.ProfileConstants.INDEXING_ENABLED;
import static java.util.stream.Collectors.toList;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {

    @Autowired
    private Environment environment;
    @Autowired
    private List<IndexService> indexServices;

    @Override
    public List searchGlobally(String query) {
        if(isIndexingProfileEnabled()) {
            return indexServices.stream()
                    .map(indexService -> indexService.searchInIndex(query))
                    .collect(toList());
        }
        return new ArrayList<>();
    }

    private boolean isIndexingProfileEnabled() {
        return Stream.of(environment.getActiveProfiles()).anyMatch(INDEXING_ENABLED::equals);
    }
}