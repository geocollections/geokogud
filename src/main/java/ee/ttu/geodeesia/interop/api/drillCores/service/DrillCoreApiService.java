package ee.ttu.geodeesia.interop.api.drillCores.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;

public interface DrillCoreApiService {
    Response findDrillCore(DrillCoreSearchCriteria searchCriteria);
}