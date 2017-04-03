package ee.ttu.geocollection.interop.api.analyses.search;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.analyses.pojo.AnalysesSearchCriteria;

import java.util.List;

public interface AnalysesApiService {
    Response findAnalyses(AnalysesSearchCriteria searchCriteria);
    Response findById(Long id);
    List<?> searchByField(String table, String term, String searchField);
}