package ee.ttu.geodeesia.interop.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import ee.ttu.geodeesia.search.domain.SortField;
import ee.ttu.geodeesia.search.domain.SortingOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${geo-api.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Response searchEntities(String tableName, int page, SortField sortField, String requestParams, Class<?> responseClass) {
        if(sortField == null) {
            sortField = new SortField();
        }

        String url = apiUrl + "/" + tableName +"/" + "?paginate_by=" + 30 + "&page=" + page
                + "&order_by="+getSortingDirection(sortField.getOrder())+sortField.getSortyBy()
                + "&format=json" + requestParams;
        System.err.println(url);
        ResponseEntity<ApiResponse> rawResponse = restTemplate.getForEntity(url, ApiResponse.class);

        Response response = new Response();

        ObjectMapper mapper = new ObjectMapper();
        response.setResult(
                mapper.convertValue(
                        rawResponse.getBody().getResult(),
                        mapper.getTypeFactory().constructCollectionType(List.class, responseClass)));

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
        return order.equals(SortingOrder.ASCENDING) ? "" : "-";
    }

    @Override
    public Response findEntity(String tableName, String requestParams, Class<?> responseClass) {
        String url = apiUrl + "/" + tableName +"/" + requestParams;

        System.err.println(url);
        ResponseEntity<ApiResponse> rawResponse = restTemplate.getForEntity(url, ApiResponse.class);

        Response response = new Response();

        ObjectMapper mapper = new ObjectMapper();
        response.setResult(
                mapper.convertValue(
                        rawResponse.getBody().getResult(),
                        mapper.getTypeFactory().constructCollectionType(List.class, responseClass)));

        System.err.println(rawResponse.getBody().getPageInfo());

        return response;
    }
}
