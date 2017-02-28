package ee.ttu.geodeesia.interop.api.samples.service;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.search.domain.CommonSearch;

public interface SamplesApiService {
    Response searchSampleList(CommonSearch search);

    Response searchSampleList(SearchApiRequest request);
}
