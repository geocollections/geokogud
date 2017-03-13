package ee.ttu.geodeesia.interop.api.reference.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceSearchCriteria;

public interface ReferenceApiService {
    Response findReference(ReferenceSearchCriteria searchCriteria);
    Response findDoi(ReferenceSearchCriteria searchCriteria);
}