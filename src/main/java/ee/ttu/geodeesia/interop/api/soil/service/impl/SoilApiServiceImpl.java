package ee.ttu.geodeesia.interop.api.soil.service.impl;

import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import org.springframework.stereotype.Service;

@Service
public class SoilApiServiceImpl implements SoilApiService{

    @Override
    public SoilApiResponse findSoil(SoilSearchCriteria searchCriteria) {
        return null;
    }
}