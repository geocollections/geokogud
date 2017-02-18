package ee.ttu.geodeesia.interop.api;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.TaxonApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by 48707222248 on 18.02.2017.
 */
@Service
public class SearchApiService {

    private static final Logger logger = LoggerFactory.getLogger(SearchApiService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${geo-api.url}")
    private String apiUrl;

    public TaxonApiResponse searchTaxon() {
        SearchApiRequest request = new SearchApiRequest();
        request.setFormat("json");
        return searchTaxon(request);
    }
    public TaxonApiResponse searchTaxon(SearchApiRequest request) {
/*        String url = apiUrl + "/taxon?format=" + request.getFormat();
        ResponseEntity<TaxonApiResponse> response = restTemplate.getForEntity(url, TaxonApiResponse.class);*/

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/taxon");
        urlBuilder.queryParam("format", "json");
        return restTemplate.getForObject(urlBuilder.build(false).toUriString(), TaxonApiResponse.class);
    }
}
