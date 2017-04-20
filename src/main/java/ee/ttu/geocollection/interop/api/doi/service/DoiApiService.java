package ee.ttu.geocollection.interop.api.doi.service;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.doi.pojo.DoiSearchCriteria;

import java.util.Map;

public interface DoiApiService {
    ApiResponse findDoi(DoiSearchCriteria searchCriteria) throws AppException;

    Map findRawById(Long id);
}