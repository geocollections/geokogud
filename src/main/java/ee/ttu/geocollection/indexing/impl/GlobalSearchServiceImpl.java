package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.GlobalSearchService;
import ee.ttu.geocollection.indexing.IndexingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {

    @Autowired
    private IndexingProperties indexingProperties;

    @Autowired
    private List<AbstractIndexingService> indexServices;

    @Override
    public List searchGlobally(String query) {
        if(indexingProperties.isIndexingEnabled()) {
            return indexServices.stream()
                    .map(indexService -> indexService.searchInIndex(query))
                    .collect(toList());
        }
        return new ArrayList<>();
    }
}