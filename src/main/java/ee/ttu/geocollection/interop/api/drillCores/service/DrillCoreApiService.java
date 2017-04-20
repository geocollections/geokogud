package ee.ttu.geocollection.interop.api.drillCores.service;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreSearchCriteria;

import java.util.Map;

public interface DrillCoreApiService {
    ApiResponse findDrillCore(DrillCoreSearchCriteria searchCriteria) throws AppException;

    Map findRawById(Long id);
}