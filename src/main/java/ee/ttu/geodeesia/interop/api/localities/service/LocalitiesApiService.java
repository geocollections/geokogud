package ee.ttu.geodeesia.interop.api.localities.service;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityApiResponse;

public interface LocalitiesApiService {

    LocalityApiResponse getLocality(Long id);

    LocalityApiResponse getLocality(Long id, SearchApiRequest request);
}
