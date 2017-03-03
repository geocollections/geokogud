package ee.ttu.geodeesia.interop.api.samples.service;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.NewVersionOfApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.search.domain.CommonSearch;

public interface SamplesApiService {
    Response searchList(CommonSearch search);

    Response searchList(SearchApiRequest request);

    NewVersionOfApiResponse getEntityInfo(String entity, Long id);

    NewVersionOfApiResponse getEntityInfo(Long id,SearchApiRequest request);
}
