package ee.ttu.geocollection.interop.api.localities.service.impl;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentLocalityImageSearchApiBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentLocalitySearchApiBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentSpecimenImageSearchApiBuilder;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityMapFilter;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;
import ee.ttu.geocollection.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class LocalitiesApiServiceImpl implements LocalitiesApiService {

    @Value("${geo-api.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findLocality(LocalitySearchCriteria searchCriteria) throws AppException {
        String requestParams = FluentLocalitySearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .queryNumber(searchCriteria.getNumber())
                .queryStratigraphy(searchCriteria.getStratigraphy())
//                .queryReference(searchCriteria.getReference()).andReturn()
                .queryMaId(searchCriteria.getMaId())
                .queryLocality(searchCriteria.getLocality())
                .queryCountry(searchCriteria.getCountry())
                .queryAdminUnit(searchCriteria.getAdminUnit())
                .queryLongitude(searchCriteria.getLatitude())
                .queryLongitude(searchCriteria.getLongitude())
                .queryDepth(searchCriteria.getVerticalExtentSince())
                .queryDepth(searchCriteria.getVerticalExtentTo())
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("locality",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams);
    }

    @Override
    public ApiResponse findLocalityImage(LocalitySearchCriteria searchCriteria) {
        String requestParams = FluentLocalityImageSearchApiBuilder.aRequest()
                .queryLocalityIdForUrl(searchCriteria.getId()).andReturn()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("image", searchCriteria.getPage(),new SortField(), requestParams);
    }


    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("image")
                .relatedData("drillcore")
                .relatedData("locality_reference")
                .relatedData("locality_synonym")
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("locality", requestParams);
    }

    @Override
    public Map findLocalitiesSummary() {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .buildWithDefaultReturningFields() + "?format=json";
        return apiService.findRawEntity("locality_summary", requestParams);
    }

    @Override
    public Map findLocalitiesSummaryFilter(LocalityMapFilter filters) {
        String requestParams =  FluentGeoApiDetailsBuilder.aRequest().buildWithDefaultReturningFields()+"?";
        if(filters.getFilters().size() > 0) {
            for(String filter: filters.getFilters()) {
                    requestParams += filter + "__gt=0&";
            }
        }
        if(filters.getLocalityName() != "") {
            requestParams += "multi_search=value:" +  filters.getLocalityName() +
                    ";fields:name,name_en;lookuptype:icontains&";
        }
        requestParams += "format=json";
        return apiService.findRawEntity("locality_summary", requestParams);
    }
}
