package ee.ttu.geodeesia.interop.api.drillCores.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreProto;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillcoreBox;

public interface DrillCoreApiService {
    Response<DrillCoreProto> findDrillCore(DrillCoreSearchCriteria searchCriteria);

    DrillCoreProto findDrillcoreById(Long id);

    DrillcoreBox findDrillcoreBoxById(Long id);
}