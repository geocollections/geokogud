package ee.ttu.geodeesia.interop.api.reference.service.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.search.FluentReferenceSearchApiBuilder;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceApiResponse;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceSearchCriteria;
import ee.ttu.geodeesia.interop.api.reference.service.ReferenceApiService;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceApiServiceImpl implements ReferenceApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public Response findReference(ReferenceSearchCriteria searchCriteria) {
        String requestParams = FluentReferenceSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryAuthor(searchCriteria.getAuthor()).andReturn()
                .queryTitle(searchCriteria.getTitle()).andReturn()
                .queryYear(searchCriteria.getYear()).andReturn()
                .queryDoi(searchCriteria.getDoi()).andReturn()
                .queryBook(searchCriteria.getBook()).andReturn()
                .queryJournal(searchCriteria.getJournal()).andReturn()
                .buildWithoutReturningCertainFields();
        return apiService.searchEntities("reference", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, ReferenceApiResponse.class);
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
                .build();
        return apiService.searchEntities("reference", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, ReferenceApiResponse.class);
    }
}