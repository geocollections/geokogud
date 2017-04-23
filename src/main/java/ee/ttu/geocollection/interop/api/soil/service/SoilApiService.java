package ee.ttu.geocollection.interop.api.soil.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilSearchCriteria;

import java.util.Map;

public interface SoilApiService {
    ApiResponse findSoil(SoilSearchCriteria searchCriteria) ;

    Map findRawById(Long id) ;
}
