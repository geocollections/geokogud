package ee.ttu.geocollection.interop.api.drillCores.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreProto;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillcoreBox;

public interface DrillCoreApiService {
    ApiResponse findDrillCore(DrillCoreSearchCriteria searchCriteria);

    DrillCoreProto findDrillcoreById(Long id);

    DrillcoreBox findDrillcoreBoxById(Long id);
}