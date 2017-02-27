package ee.ttu.geodeesia.interop.api.localities.service.impl;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityApiResponse;
import ee.ttu.geodeesia.interop.api.localities.service.LocalitiesApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocalitiesApiServiceImpl implements LocalitiesApiService {

    @Value("${geo-api.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

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
