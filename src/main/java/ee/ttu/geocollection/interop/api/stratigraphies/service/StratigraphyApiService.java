package ee.ttu.geocollection.interop.api.stratigraphies.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;

public interface StratigraphyApiService {
    ApiResponse findStratigraphy(StratigraphySearchCriteria searchCriteria);

    Response<StratigraphyEnitity> findById(Long id);
}
