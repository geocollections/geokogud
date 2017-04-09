package ee.ttu.geocollection.interop.api.stratigraphies.service.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentStratigraphySearchApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;
import ee.ttu.geocollection.interop.api.stratigraphies.service.StratigraphyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StratigraphyApiServiceImpl implements StratigraphyApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findStratigraphy(StratigraphySearchCriteria searchCriteria) {
        String requestParams = FluentStratigraphySearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .queryStratigraphy(searchCriteria.getStratigraphy())
                .queryIndex(searchCriteria.getIndex())
                .queryAgeBase(searchCriteria.getAgeMinY())
                .queryLithology(searchCriteria.getMainLithology())
                .queryAuthor(searchCriteria.getAuthor())
                .buildWithoutReturningCertainFields();
        return apiService.searchRawEntities(
                    "stratigraphy",
                    searchCriteria.getPage(),
                    searchCriteria.getSortField(),
                    requestParams);
    }

    @Override
    public Response<StratigraphyEnitity> findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest().id(id).buildWithDefaultReturningFields();
        return apiService.findEntity(
                "stratigraphy",
                requestParams,
                StratigraphyEnitity.class);
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("stratigraphy_reference")
                .relatedData("stratigraphy_stratotype")
                .relatedData("stratigraphy_synonym")
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("stratigraphy", requestParams);
    }

}
