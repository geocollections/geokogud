package ee.ttu.geocollection.interop.api.localities.service.impl;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Request.SearchApiRequest;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentLocalitySearchApiBuilder;
import ee.ttu.geocollection.interop.api.localities.pojo.Locality;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityApiResponse;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;
import ee.ttu.geocollection.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
                .buildWithoutReturningCertainFields();
        return apiService.searchRawEntities("locality",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams);
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
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("locality_summary", requestParams);
    }
}
