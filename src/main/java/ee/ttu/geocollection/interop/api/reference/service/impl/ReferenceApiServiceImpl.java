package ee.ttu.geocollection.interop.api.reference.service.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentReferenceSearchApiBuilder;
import ee.ttu.geocollection.interop.api.reference.pojo.Reference;
import ee.ttu.geocollection.interop.api.reference.pojo.ReferenceSearchCriteria;
import ee.ttu.geocollection.interop.api.reference.service.ReferenceApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReferenceApiServiceImpl implements ReferenceApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findReference(ReferenceSearchCriteria searchCriteria) {
        String requestParams = FluentReferenceSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryAuthor(searchCriteria.getAuthor()).andReturn()
                .queryTitle(searchCriteria.getTitle()).andReturn()
                .queryYear(searchCriteria.getYear()).andReturn()
                .queryDoi(searchCriteria.getDoi()).andReturn()
                .queryBook(searchCriteria.getBook()).andReturn()
                .queryJournal(searchCriteria.getJournal()).andReturn()
                .buildWithoutReturningCertainFields();
        return apiService.searchRawEntities("reference", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public Response findDoi(ReferenceSearchCriteria searchCriteria) {
        String requestParams = FluentReferenceSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryAuthor(searchCriteria.getAuthor()).andReturn()
                .queryTitle(searchCriteria.getTitle()).andReturn()
                .queryYear(searchCriteria.getYear()).andReturn()
                .queryDoi(searchCriteria.getDoi()).andReturn()
                .fieldIsNotNull("doi")
                .buildWithReturningCertainFields();
        return apiService.searchEntities("reference", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, Reference.class);
    }

    @Override
    public Response<Reference> findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest().id(id).buildWithDefaultReturningFields();
        return apiService.findEntity("reference", requestParams, Reference.class);
    }

    @Override
    public Response<Reference> findDoiById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest().id(id).buildWithDefaultReturningFields();
        return apiService.findEntity("reference", requestParams, Reference.class);
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("reference", requestParams);
    }

}