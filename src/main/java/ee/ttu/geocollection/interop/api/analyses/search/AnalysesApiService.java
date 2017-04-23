package ee.ttu.geocollection.interop.api.analyses.search;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.analyses.pojo.AnalysesSearchCriteria;

import java.util.Map;

public interface AnalysesApiService {
    ApiResponse findAnalyses(AnalysesSearchCriteria searchCriteria) ;

    Map findRawById(Long id);
}