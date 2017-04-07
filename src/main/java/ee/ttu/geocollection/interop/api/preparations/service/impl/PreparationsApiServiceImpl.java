package ee.ttu.geocollection.interop.api.preparations.service.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.search.FluentPreparationSearchApiBuilder;
import ee.ttu.geocollection.interop.api.preparations.PreparationsApiService;
import ee.ttu.geocollection.interop.api.preparations.pojo.PreparationsSearchCriteria;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreparationsApiServiceImpl implements PreparationsApiService{
    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findPreparations(PreparationsSearchCriteria searchCriteria) {

        String requestParams = FluentPreparationSearchApiBuilder.aRequest()
                .queryNumber(searchCriteria.getNumber())
                .queryLocality(searchCriteria.getLocality())
                .queryLocalityEn(searchCriteria.getLocalityEn())
                .queryCollector(searchCriteria.getCollector())
                .queryStratigraphy(searchCriteria.getStratigraphy())
                .queryStratigraphyEn(searchCriteria.getStratigraphyEn())
                .queryDepth(searchCriteria.getDepth())
                .buildWithoutReturningCertainFields();
        return apiService.searchRawEntities("preparation", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }
}