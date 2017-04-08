package ee.ttu.geocollection.interop.api.soil.service.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentSoilSearchApiApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.soil.pojo.Soil;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilHorizon;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geocollection.interop.api.soil.service.SoilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilApiServiceImpl implements SoilApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findSoil(SoilSearchCriteria searchCriteria) {
        String requestParams = FluentSoilSearchApiApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .querySite(searchCriteria.getSite())
                .queryAreaName(searchCriteria.getAreaOfStudy())
                .queryLandUse(searchCriteria.getLandUse())
                .querySoil(searchCriteria.getSoilName())
                .queryTransect(searchCriteria.getTransect())
                .queryDeepMining(searchCriteria.getDeepMining())
                .returnLatitude()
                .returnLongitude()
                .returnTransectPoint()
                .buildWithoutReturningCertainFields();
        return apiService.searchRawEntities("soil_site", searchCriteria.getPage(),searchCriteria.getSortField(), requestParams);
    }

    @Override
    public Soil findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findEntityAndMagicallyDeserialize("soil_site", requestParams, Soil.class);
    }

    @Override
    public Response<SoilHorizon> findSoilHorizons(SoilSearchCriteria searchCriteria) {
        return null;
    }
}