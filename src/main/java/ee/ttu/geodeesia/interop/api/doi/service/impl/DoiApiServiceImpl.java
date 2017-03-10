package ee.ttu.geodeesia.interop.api.doi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.Response.ResponseMapper;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiBuilder;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiApiResponse;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiSearchCriteria;
import ee.ttu.geodeesia.interop.api.doi.service.DoiApiService;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import ee.ttu.geodeesia.search.domain.SortField;
import ee.ttu.geodeesia.search.domain.SortingOrder;
import microsoft.exchange.webservices.data.core.enumeration.search.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DoiApiServiceImpl implements DoiApiService {
    @Value("${geo-api.url}")
    private String apiUrl;
    @Autowired
    private ResponseMapper responseMapper;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Response findDoi(DoiSearchCriteria searchCriteria) {
        String requestParams = FluentGeoApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryDoi(searchCriteria.getDoi()).andReturn()
                .build();
        String url = apiUrl + "/" + "image/"
                + "?paginate_by=" + 30
                + "&page=" + searchCriteria.getPage()
               // + "&order_by="+getSortingDirection(searchCriteria.getSortField().getOrder()) +searchCriteria.getSortField().getSortyBy()
                + "&format=" + "json" + requestParams;
        ResponseEntity<ApiResponse> rawResponse = restTemplate.getForEntity(url, ApiResponse.class);

        Response response = new Response();

        ObjectMapper mapper = new ObjectMapper();
        response.setResult(
                mapper.convertValue(
                        rawResponse.getBody().getResult(),
                        mapper.getTypeFactory().constructCollectionType(List.class, DoiApiResponse.class)));

        response.setCount(rawResponse.getBody().getCount());
        if(rawResponse.getBody().getPageInfo() != null) {
            response.setCurrentPage(Integer.parseInt(rawResponse.getBody().getPageInfo().split("\\s")[1])); //Page 1 of 39
            response.setNumberOfPages(Integer.parseInt(rawResponse.getBody().getPageInfo().split("\\s")[3]));
        }else{
            response.setCurrentPage(1);
            response.setNumberOfPages(1);
        }

        System.err.println(rawResponse.getBody().getPageInfo());

        return response;
    }

    private String getSortingDirection(SortingOrder order){
        return order.equals(SortDirection.Ascending) ? "" : "-";
    }
}