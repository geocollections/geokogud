package ee.ttu.geocollection.interop.api.soil.service.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentSoilSearchApiApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geocollection.interop.api.soil.service.SoilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SoilApiServiceImpl implements SoilApiService {
    @Autowired
    private ApiService apiService;
    private List<String> fields = Arrays.asList(
        "id",
        "area_name",
        "land_use",
        "latitude",
        "longitude",
        "coordx",
        "coordy",
        "coord_system",
        "k_size_a",
        "k_aste_a",
        "date",
        "date_free",
        "site",
        "site_en",
        "soil",
        "is_deep",
        "transect",
        "transect_point"
    );
    @Override
    public ApiResponse findSoil(SoilSearchCriteria searchCriteria)  {
        String requestParams = FluentSoilSearchApiApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .groupById()
                .querySite(searchCriteria.getSite())
                .queryAreaName(searchCriteria.getAreaOfStudy())
                .queryLandUse(searchCriteria.getLandUse())
                .querySoil(searchCriteria.getSoilName())
                .queryTransect(searchCriteria.getTransect())
                .queryDeepMining(searchCriteria.getDeepMining())
                .returnLatitude()
                .returnLongitude()
                .returnTransectPoint()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("soil_site", searchCriteria.getPage(),searchCriteria.getSortField(), requestParams);
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("sample")
                .relatedData("soil_horizon")
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
        return apiService.findRawEntity("soil_site", requestParams);
    }
}