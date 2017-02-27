package ee.ttu.geodeesia.interop.api.samples.service;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleSearch;

public interface SamplesApiService {
    Response searchSampleList(SampleSearch search);

    Response searchSampleList(SearchApiRequest request);
}
