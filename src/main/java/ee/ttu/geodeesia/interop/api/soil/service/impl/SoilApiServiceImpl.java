package ee.ttu.geodeesia.interop.api.soil.service.impl;

import ee.ttu.geodeesia.interop.api.service.ApiService;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.Response.ResponseMapper;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiBuilder;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilApiServiceImpl implements SoilApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public Response findSoil(SoilSearchCriteria searchCriteria) {
        String requestParams = FluentGeoApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .querySite(searchCriteria.getSite()).andReturn()
                .queryAreaName(searchCriteria.getAreaOfStudy()).andReturn()
                .queryLandUse(searchCriteria.getLandUse()).andReturn()
                .querySoil(searchCriteria.getSoilName()).andReturn()
                .queryTransect(searchCriteria.getTransect()).andReturn()
                .queryDeepMining(searchCriteria.getDeepMining()).andReturn()
                .returnLatitude()
                .returnLongitude()
                .returnTransectPoint()
                .build();
        return apiService.findEntity("soil_site", searchCriteria.getPage(), requestParams, SoilApiResponse.class);
    }
}