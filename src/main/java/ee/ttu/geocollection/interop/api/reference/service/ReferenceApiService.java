package ee.ttu.geocollection.interop.api.reference.service;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.reference.pojo.ReferenceSearchCriteria;

public interface ReferenceApiService {
    Response findReference(ReferenceSearchCriteria searchCriteria);
    Response findDoi(ReferenceSearchCriteria searchCriteria);

    Response findById(Long id);

    Response findDoiById(Long id);
}