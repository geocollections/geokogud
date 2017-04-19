package ee.ttu.geocollection.interop.api.stratigraphies.service;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;

import java.util.Map;

public interface StratigraphyApiService {
    ApiResponse findStratigraphy(StratigraphySearchCriteria searchCriteria) throws AppException;

    Map findRawById(Long id);
}
