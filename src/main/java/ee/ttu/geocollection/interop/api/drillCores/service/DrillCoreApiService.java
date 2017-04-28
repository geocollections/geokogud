package ee.ttu.geocollection.interop.api.drillCores.service;

import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreSearchCriteria;

import java.util.Map;

public interface DrillCoreApiService {
    ApiResponse findDrillCore(DrillCoreSearchCriteria searchCriteria) ;

    ApiResponse findDrillCoreImage(SearchField drillCoreId) ;

    Map findRawById(Long id);
    Map findRawCoreBoxById(Long id);
}