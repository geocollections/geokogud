package ee.ttu.geocollection.interop.api.doi.service;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.doi.pojo.DoiSearchCriteria;

import java.util.List;

public interface DoiApiService {
    Response findDoi(DoiSearchCriteria searchCriteria);
    Response findById(Long id);
    List<?> searchByField(String table, String term, String searchField);
}