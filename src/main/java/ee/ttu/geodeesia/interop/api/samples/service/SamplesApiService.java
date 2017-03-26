package ee.ttu.geodeesia.interop.api.samples.service;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.NewVersionOfApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleEntity;
import ee.ttu.geodeesia.search.domain.CommonSearch;

public interface SamplesApiService {

    Response findSample(ee.ttu.geodeesia.interop.api.samples.pojo.SampleSearchCriteria searchCriteria);

    Response findById(Long id);

    Response searchByParam(String q, String table);

    Response searchList(CommonSearch search);

    Response searchList(SearchApiRequest request);

    NewVersionOfApiResponse getEntityInfo(String entity, Long id);

    NewVersionOfApiResponse getEntityInfo(Long id,SearchApiRequest request);

    Response<SampleEntity> searchSamples(ee.ttu.geodeesia.interop.api.Request.SampleSearchCriteria criteria);
}
