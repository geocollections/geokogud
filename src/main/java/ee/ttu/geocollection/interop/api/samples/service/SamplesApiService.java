package ee.ttu.geocollection.interop.api.samples.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;

import java.util.Map;

public interface SamplesApiService {

    ApiResponse findSample(SampleSearchCriteria searchCriteria);

    Map findRawById(Long id);

    ApiResponse findSampleForIndex(SampleSearchCriteria searchCriteria);
}
