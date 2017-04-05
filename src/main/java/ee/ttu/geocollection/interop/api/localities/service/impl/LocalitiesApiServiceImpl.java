package ee.ttu.geocollection.interop.api.localities.service.impl;

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
    public ApiResponse findLocality(LocalitySearchCriteria searchCriteria) {
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
                .buildWithoutReturningCertainFields();
        return apiService.searchRawEntities("locality",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams);
    }

    @Override
    public Response<Locality> findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("image")
                .relatedData("drillcore")
                .relatedData("reference")
                .buildWithDefaultReturningFields();
        return apiService.findEntity("locality", requestParams, Locality.class);
    }

    @Override
    public LocalityApiResponse getLocality(Long id) {
        return getLocality(id, new SearchApiRequest());
    }

    @Override
    public LocalityApiResponse getLocality(Long id, SearchApiRequest request) {
        String url = apiUrl + "/locality/" + id + "?format=" + request.getOutputFormat();
        ResponseEntity<LocalityApiResponse> response = restTemplate.getForEntity(url, LocalityApiResponse.class);
        return response.getBody();
    }

    @Override
    public Map findLocalitiesSummary() {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .buildWithDefaultReturningFields();
        return apiService.findRawEntities("locality_summary", requestParams);
    }
}
