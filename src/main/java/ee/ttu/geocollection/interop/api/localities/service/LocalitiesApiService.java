package ee.ttu.geocollection.interop.api.localities.service;

import ee.ttu.geocollection.interop.api.Request.SearchApiRequest;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.localities.pojo.Locality;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityApiResponse;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;

import java.util.Map;

public interface LocalitiesApiService {

    Response findLocality(LocalitySearchCriteria searchCriteria);

    Response<Locality> findById(Long id);

    LocalityApiResponse getLocality(Long id);

    LocalityApiResponse getLocality(Long id, SearchApiRequest request);

    Map findLocalitiesSummary();
}
