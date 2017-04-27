package ee.ttu.geocollection.interop.api.reference.service.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentReferenceSearchApiBuilder;
import ee.ttu.geocollection.interop.api.reference.pojo.ReferenceSearchCriteria;
import ee.ttu.geocollection.interop.api.reference.service.ReferenceApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReferenceApiServiceImpl implements ReferenceApiService {
    public static final String REFERENCE_TABLE = "reference";
    @Autowired
    private ApiService apiService;
    @Autowired
    private IndexingProperties indexingProperties;

    @Override
    public ApiResponse findReference(ReferenceSearchCriteria searchCriteria)  {
        String requestParams = FluentReferenceSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryAuthor(searchCriteria.getAuthor()).andReturn()
                .queryTitle(searchCriteria.getTitle()).andReturn()
                .queryYear(searchCriteria.getYearSince()).andReturn()
                .queryYear(searchCriteria.getYearTo()).andReturn()
                .queryDoi(searchCriteria.getDoi()).andReturn()
                .queryBook(searchCriteria.getBook()).andReturn()
                .queryJournal(searchCriteria.getJournal()).andReturn()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(REFERENCE_TABLE, searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity(REFERENCE_TABLE, requestParams);
    }

    @Override
    public ApiResponse findReferencesForIndex(ReferenceSearchCriteria searchCriteria) {
        String requestParams = FluentReferenceSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryAuthor(searchCriteria.getAuthor()).andReturn()
                .queryTitle(searchCriteria.getTitle()).andReturn()
                .queryYear(searchCriteria.getYearSince()).andReturn()
                .queryReference(null).andReturn()
                .returnDateChanged()
                .buildFullQuery();
        return apiService.searchRawEntities(
                REFERENCE_TABLE, indexingProperties.getIndexingBatchSize(), searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findImagesByIds(List<String> ids) {
        String requestParams = FluentReferenceSearchApiBuilder.aRequest()
                .queryMultipleIds(ids)
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(REFERENCE_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }

}