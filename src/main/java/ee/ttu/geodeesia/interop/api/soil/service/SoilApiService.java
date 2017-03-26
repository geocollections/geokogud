package ee.ttu.geodeesia.interop.api.soil.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;

public interface SoilApiService {
    Response<SoilApiResponse> findSoil(SoilSearchCriteria searchCriteria);

    Response<SoilApiResponse> findById(Long id);
}
