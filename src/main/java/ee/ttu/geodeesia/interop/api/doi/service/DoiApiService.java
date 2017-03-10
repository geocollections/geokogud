package ee.ttu.geodeesia.interop.api.doi.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiSearchCriteria;

public interface DoiApiService {
    Response findDoi(DoiSearchCriteria searchCriteria);
}