package ee.ttu.geocollection.interop.api.analyses.search.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.analyses.pojo.AnalysesEntity;
import ee.ttu.geocollection.interop.api.analyses.pojo.AnalysesSearchCriteria;
import ee.ttu.geocollection.interop.api.analyses.search.AnalysesApiService;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentDoiSearchApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysesApiServiceImpl implements AnalysesApiService{
    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findAnalyses(AnalysesSearchCriteria searchCriteria) {
        String requestParams = FluentDoiSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .buildWithoutReturningCertainFields();
        return apiService.searchRawEntities("analysis", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

        @Override
    public Response findById(Long id) {
            String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                    .id(id)
                    .buildWithDefaultReturningFields();
            return apiService.findEntity("analysis", requestParams, AnalysesEntity.class);
        }

    @Override
    public List<?> searchByField(String table, String term, String searchField) {
        return null;
    }
}