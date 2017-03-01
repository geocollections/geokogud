package ee.ttu.geodeesia.interop.api.soil.service;

import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;

public interface SoilApiService {
    SoilApiResponse findSoil(SoilSearchCriteria searchCriteria);
}
