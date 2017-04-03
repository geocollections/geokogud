package ee.ttu.geocollection.interop.api.taxon.service.impl;

import ee.ttu.geocollection.interop.api.Request.SearchApiRequest;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.taxon.pojo.TaxonApiResponse;
import ee.ttu.geocollection.interop.api.taxon.service.TaxonApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaxonApiServiceImpl implements TaxonApiService {

    @Value("${geo-api.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public TaxonApiResponse searchTaxon(String q) {
        SearchApiRequest request = new SearchApiRequest();
        request.setField("taxon");
        request.setSearchCriteria("istartswith");
        return searchTaxon(q, request);
    }

    @Override
    public TaxonApiResponse searchTaxon(String q, SearchApiRequest request) {
        String url = apiUrl + "/taxon?format=" + request.getOutputFormat() + "&" + request.getField() + "__" + request.getSearchCriteria() + "=" + q;
        ResponseEntity<TaxonApiResponse> response = restTemplate.getForEntity(url, TaxonApiResponse.class);
        return response.getBody();
    }

    @Override
    public ApiResponse searchByField(String q, String table) {
        SearchApiRequest request = new SearchApiRequest();
        request.setTable(table);
        request.setField(table);
        request.setSearchCriteria("istartswith");
        return searchByField(q, request);
    }

    @Override
    public ApiResponse searchByField(String q, SearchApiRequest request) {
        String url = apiUrl + "/"+request.getTable()+"?format=" + request.getOutputFormat() + "&" + request.getField() + "__" + request.getSearchCriteria() + "=" + q;
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
        return response.getBody();
    }

    @Override
    public TaxonApiResponse searchTaxonList() {
        return searchTaxonList(new SearchApiRequest());
    }

    @Override
    public TaxonApiResponse searchTaxonList(SearchApiRequest request) {
        String url = apiUrl + "/taxon?format=" + request.getOutputFormat();
        ResponseEntity<TaxonApiResponse> response = restTemplate.getForEntity(url, TaxonApiResponse.class);

        /* This syntax is also working

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/taxon");
        urlBuilder.queryParam("format", "json");
        return restTemplate.getForObject(urlBuilder.build(false).toUriString(), TaxonApiResponse.class);

        */

        return response.getBody();
    }
}
