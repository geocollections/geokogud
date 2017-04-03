package ee.ttu.geodeesia.interop.api.analyses.search;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.analyses.pojo.AnalysesSearchCriteria;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiSearchCriteria;

import java.util.List;

public interface AnalysesApiService {
    Response findAnalyses(AnalysesSearchCriteria searchCriteria);
    Response findById(Long id);
    List<?> searchByField(String table, String term, String searchField);
}