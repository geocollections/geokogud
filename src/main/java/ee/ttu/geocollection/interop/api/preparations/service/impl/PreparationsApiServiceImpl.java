package ee.ttu.geocollection.interop.api.preparations.service.impl;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.search.FluentPreparationSearchApiBuilder;
import ee.ttu.geocollection.interop.api.preparations.PreparationsApiService;
import ee.ttu.geocollection.interop.api.preparations.pojo.Preparation;
import ee.ttu.geocollection.interop.api.preparations.pojo.PreparationsSearchCriteria;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreparationsApiServiceImpl implements PreparationsApiService{
    @Autowired
    private ApiService apiService;

    @Override
    public Response findPreparations(PreparationsSearchCriteria searchCriteria) {

        String requestParams = FluentPreparationSearchApiBuilder.aRequest()
                .queryNumber(searchCriteria.getNumber()).andReturn()
                .queryLocality(searchCriteria.getLocality()).andReturn()
                .queryLocalityEn(searchCriteria.getLocalityEn()).andReturn()
                .queryCollector(searchCriteria.getCollector()).andReturn()
                .queryStratigraphy(searchCriteria.getStratigraphy()).andReturn()
                .queryStratigraphyEn(searchCriteria.getStratigraphyEn()).andReturn()
                .queryDepth(searchCriteria.getDepth()).andReturn()
                .buildWithoutReturningCertainFields();
        return apiService.searchEntities("preparation", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, Preparation.class);
    }
}