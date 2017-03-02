package ee.ttu.geodeesia.interop.api.soil.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;

import java.util.List;

public interface SoilApiService {
    Response findSoil(SoilSearchCriteria searchCriteria);
}
