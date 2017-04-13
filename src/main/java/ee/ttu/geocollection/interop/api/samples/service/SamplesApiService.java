package ee.ttu.geocollection.interop.api.samples.service;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;

import java.util.Map;

public interface SamplesApiService {

    ApiResponse findSample(SampleSearchCriteria searchCriteria) throws AppException;

    Map findRawById(Long id) throws AppException;
}
