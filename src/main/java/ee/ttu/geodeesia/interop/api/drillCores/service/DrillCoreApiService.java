package ee.ttu.geodeesia.interop.api.drillCores.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.deserializer.protoPojo.DrillCoreProto;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreSearchCriteria;

public interface DrillCoreApiService {
    Response<DrillCoreProto> findDrillCore(DrillCoreSearchCriteria searchCriteria);

    DrillCoreProto findById(Long id);
}