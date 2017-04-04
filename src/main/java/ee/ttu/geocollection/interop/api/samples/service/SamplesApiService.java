package ee.ttu.geocollection.interop.api.samples.service;

import ee.ttu.geocollection.interop.api.Request.SearchApiRequest;
import ee.ttu.geocollection.interop.api.Response.NewVersionOfApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.samples.pojo.Sample;
import ee.ttu.geocollection.search.domain.CommonSearch;

import java.util.Map;

public interface SamplesApiService {

    Response findSample(ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria searchCriteria);

    Response findById(Long id);

    Map findRawById(Long id);

    Response searchByParam(String q, String table);

    Response searchList(CommonSearch search);

    Response searchList(SearchApiRequest request);

    NewVersionOfApiResponse getEntityInfo(String entity, Long id);

    NewVersionOfApiResponse getEntityInfo(Long id,SearchApiRequest request);

    Response<Sample> searchSamples(ee.ttu.geocollection.interop.api.Request.SampleSearchCriteria criteria);
}
