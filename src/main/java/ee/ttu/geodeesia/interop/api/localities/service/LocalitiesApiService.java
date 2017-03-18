package ee.ttu.geodeesia.interop.api.localities.service;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityApiResponse;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalitySearchCriteria;

public interface LocalitiesApiService {

    Response findLocality(LocalitySearchCriteria searchCriteria);

    Response findById(Long id);

    LocalityApiResponse getLocality(Long id);

    LocalityApiResponse getLocality(Long id, SearchApiRequest request);
}
