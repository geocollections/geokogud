package ee.ttu.geodeesia.interop.api.localities.service.impl;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geodeesia.interop.api.builder.search.FluentLocalitySearchApiBuilder;
import ee.ttu.geodeesia.interop.api.localities.pojo.Locality;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityApiResponse;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityEntity;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalitySearchCriteria;
import ee.ttu.geodeesia.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocalitiesApiServiceImpl implements LocalitiesApiService {

    @Value("${geo-api.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ApiService apiService;

    @Override
    public Response findLocality(LocalitySearchCriteria searchCriteria) {
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
                .queryInstitution(searchCriteria.getDbs())
                .buildWithoutReturningCertainFields();
        return apiService.searchEntities("locality",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams,
                LocalityEntity.class);
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
}
