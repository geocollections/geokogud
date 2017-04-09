package ee.ttu.geocollection.interop.api.reference.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.reference.pojo.ReferenceSearchCriteria;

import java.util.Map;

public interface ReferenceApiService {
    ApiResponse findReference(ReferenceSearchCriteria searchCriteria);
    Response findDoi(ReferenceSearchCriteria searchCriteria);

    Response findById(Long id);

    Response findDoiById(Long id);

    Map findRawById(Long id);
}