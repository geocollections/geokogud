package ee.ttu.geocollection.interop.api.stratigraphies.service.impl;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentStratigraphySearchApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;
import ee.ttu.geocollection.interop.api.stratigraphies.service.StratigraphyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StratigraphyApiServiceImpl implements StratigraphyApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public Response<StratigraphyEnitity> findStratigraphy(StratigraphySearchCriteria searchCriteria) {
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
    public Response<StratigraphyEnitity> findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest().id(id).buildWithDefaultReturningFields();
        return apiService.findEntity(
                "stratigraphy",
                requestParams,
                StratigraphyEnitity.class);
    }
}
