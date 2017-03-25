package ee.ttu.geodeesia.interop.api.stratigraphies.service.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.search.FluentStratigraphySearchApiBuilder;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import ee.ttu.geodeesia.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import ee.ttu.geodeesia.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;
import ee.ttu.geodeesia.interop.api.stratigraphies.service.StratigraphyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StratigraphyApiServiceImpl implements StratigraphyApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public Response findStratigraphy(StratigraphySearchCriteria searchCriteria) {
        String requestParams = FluentStratigraphySearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .queryStratigraphy(searchCriteria.getStratigraphy())
                .queryIndex(searchCriteria.getIndex())
                .buildWithoutReturningCertainFields();
        return apiService.searchEntities(
                    "stratigraphy",
                    searchCriteria.getPage(),
                    searchCriteria.getSortField(),
                    requestParams,
                    StratigraphyEnitity.class);
    }

    @Override
    public Response findById(Long id) {
        return null;
    }
}
