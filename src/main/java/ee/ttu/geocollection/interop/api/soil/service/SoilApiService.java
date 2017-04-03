package ee.ttu.geocollection.interop.api.soil.service;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.soil.pojo.Soil;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilHorizon;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilSearchCriteria;

public interface SoilApiService {
    Response<Soil> findSoil(SoilSearchCriteria searchCriteria);

    Soil findById(Long id);

    Response<SoilHorizon> findSoilHorizons(SoilSearchCriteria searchCriteria);
}
