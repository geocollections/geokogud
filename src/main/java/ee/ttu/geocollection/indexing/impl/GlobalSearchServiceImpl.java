package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.GlobalSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {

    @Value("${globalSearch.indexing}")
    private boolean indexingEnabled;

    @Autowired
    private Environment environment;
    @Autowired
    private List<AbstractIndexingService> indexServices;

    @Override
    public List searchGlobally(String query) {
        if(indexingEnabled) {
            return indexServices.stream()
                    .map(indexService -> indexService.searchInIndex(query))
                    .collect(toList());
        }
        return new ArrayList<>();
    }
}