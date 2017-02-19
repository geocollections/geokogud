package ee.ttu.geodeesia.interop.api;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.LocalityApiResponse;
import ee.ttu.geodeesia.interop.api.Response.TaxonApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 48707222248 on 18.02.2017.
 */
@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${geo-api.url}")
    private String apiUrl;

    public TaxonApiResponse searchTaxonList() {
        return searchTaxonList(new SearchApiRequest());
    }
    public TaxonApiResponse searchTaxonList(SearchApiRequest request) {
        String url = apiUrl + "/taxon?format=" + request.getOutputFormat();
        ResponseEntity<TaxonApiResponse> response = restTemplate.getForEntity(url, TaxonApiResponse.class);

        /* This syntax is also working

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/taxon");
        urlBuilder.queryParam("format", "json");
        return restTemplate.getForObject(urlBuilder.build(false).toUriString(), TaxonApiResponse.class);

        */

        return  response.getBody();
    }

    public TaxonApiResponse searchTaxon(String q) {
        SearchApiRequest request = new SearchApiRequest();
        request.setField("taxon");
        request.setSearchCriteria("istartswith");
        return searchTaxon(q,request);
    }
    public TaxonApiResponse searchTaxon(String q, SearchApiRequest request) {
        String url = apiUrl + "/taxon?format=" + request.getOutputFormat()+"&"+request.getField()+"__"+request.getSearchCriteria()+"="+q;
        ResponseEntity<TaxonApiResponse> response = restTemplate.getForEntity(url, TaxonApiResponse.class);
        return  response.getBody();
    }

    public LocalityApiResponse getLocality(Long id) {
        return getLocality(id,new SearchApiRequest());
    }
    public LocalityApiResponse getLocality(Long id, SearchApiRequest request) {
        String url = apiUrl + "/locality/"+id+"?format=" + request.getOutputFormat();
        ResponseEntity<LocalityApiResponse> response = restTemplate.getForEntity(url, LocalityApiResponse.class);
        return  response.getBody();
    }
}
