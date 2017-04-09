package ee.ttu.geocollection.interop.api.soil.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.soil.pojo.Soil;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilHorizon;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilSearchCriteria;

import java.util.Map;

public interface SoilApiService {
    ApiResponse findSoil(SoilSearchCriteria searchCriteria);

    Soil findById(Long id);

    Response<SoilHorizon> findSoilHorizons(SoilSearchCriteria searchCriteria);

    Map findRawById(Long id);
}
