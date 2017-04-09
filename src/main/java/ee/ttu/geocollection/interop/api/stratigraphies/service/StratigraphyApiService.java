package ee.ttu.geocollection.interop.api.stratigraphies.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;

import java.util.Map;

public interface StratigraphyApiService {
    ApiResponse findStratigraphy(StratigraphySearchCriteria searchCriteria);

    Response<StratigraphyEnitity> findById(Long id);

    Map findRawById(Long id);
}
