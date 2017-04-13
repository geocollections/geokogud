package ee.ttu.geocollection.interop.api.localities.service;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Request.SearchApiRequest;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.localities.pojo.Locality;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityApiResponse;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;

import java.util.Map;

public interface LocalitiesApiService {

    ApiResponse findLocality(LocalitySearchCriteria searchCriteria) throws AppException;

    Map findRawById(Long id);

    Map findLocalitiesSummary();
}
