package ee.ttu.geodeesia.interop.api.doi.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiSearchCriteria;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceSearchCriteria;

import java.util.List;

public interface DoiApiService {
    Response findDoi(DoiSearchCriteria searchCriteria);
    Response findById(Long id);
    List<?> searchByField(String table, String term, String searchField);
}