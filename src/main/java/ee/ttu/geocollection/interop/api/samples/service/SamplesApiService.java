package ee.ttu.geocollection.interop.api.samples.service;

import ee.ttu.geocollection.interop.api.Request.SearchApiRequest;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.NewVersionOfApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.samples.pojo.Sample;
import ee.ttu.geocollection.search.domain.CommonSearch;

import java.util.Map;

public interface SamplesApiService {

    ApiResponse findSample(ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria searchCriteria);

    Map findRawById(Long id);
}
