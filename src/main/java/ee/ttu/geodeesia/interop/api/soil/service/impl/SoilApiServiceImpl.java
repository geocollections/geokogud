package ee.ttu.geodeesia.interop.api.soil.service.impl;

import ee.ttu.geodeesia.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geodeesia.interop.api.builder.search.FluentSoilSearchApiApiBuilder;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import ee.ttu.geodeesia.interop.api.Response.Response;
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
        String requestParams = FluentSoilSearchApiApiBuilder.aRequest()
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
        return apiService.searchEntities("soil_site", searchCriteria.getPage(),searchCriteria.getSortField(), requestParams, SoilApiResponse.class);
    }

    @Override
    public Response findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .returnId()
                .returnSite()
                .returnAreaName()
                .returnLandUse()
                .returnSoil()
                .returnTransect()
                .returnDeepMining()
                .returnLatitude()
                .returnLongitude()
                .returnTransectPoint()
                .build();
        return apiService.findEntity("soil_site", requestParams, SoilApiResponse.class);
    }
}