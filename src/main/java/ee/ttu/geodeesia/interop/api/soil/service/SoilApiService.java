package ee.ttu.geodeesia.interop.api.soil.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.soil.pojo.Soil;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilHorizon;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;

public interface SoilApiService {
    Response<Soil> findSoil(SoilSearchCriteria searchCriteria);

    Soil findById(Long id);

    Response<SoilHorizon> findSoilHorizons(SoilSearchCriteria searchCriteria);
}
