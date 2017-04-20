package ee.ttu.geocollection.interop.api.service.impl;

import ee.ttu.geocollection.domain.AppError;
import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Value("${geo-api.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Map findRawEntity(String tableName, String requestParams) {
        String url = apiUrl + "/" + tableName + "/" + requestParams;

        HttpHeaders headers = new HttpHeaders();
        String requestId = MDC.get("REQUEST_UUID");
        if (requestId != null) {
            headers.set("Trace-UUID", requestId);
        }
        HttpEntity<String> request = new HttpEntity<String>(headers);
        System.err.println(url);
        HttpEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
        return response.getBody();
    }

    @Override
    public ApiResponse searchRawEntities(String tableName, int page, SortField sortField, String requestParams) {
        return searchRawEntities(tableName, 30, page, sortField, requestParams);
    }

    @Override
    public ApiResponse searchRawEntities(String tableName, int paginateBy, int page, SortField sortField, String requestParams) {
        String url = apiUrl + "/" + tableName + "/" + "?paginate_by=" + paginateBy + "&page=" + page
                + "&order_by=" + getSortingDirection(sortField.getOrder()) + sortField.getSortBy()
                + "&format=json" + requestParams;
        logger.trace("Searching: " + url);
        try {
            ResponseEntity<ApiResponse> rawResponse = restTemplate.getForEntity(url, ApiResponse.class);
            return rawResponse.getBody();
        } catch (HttpMessageNotReadableException e) {
            throw new AppException(AppError.BAD_REQUEST);
        } catch (HttpServerErrorException e) {
            throw new AppException(AppError.ERROR_API_UNAVAILABLE);
        }
    }

    private String getSortingDirection(SortingOrder order) {
        return order.equals(SortingOrder.ASCENDING) ? "" : "-";
    }


    @Override
    public Map searchByField(String table, String term, String searchField) {
        String url = apiUrl + "/" + table + "/" + "?paginate_by=" + 30
                + "&format=json&fields=" + searchField + "&multi_search=value:"+term+";fields:"+searchField+";lookuptype:icontains"
                + "&group_by="+searchField;

        System.err.println(url);
        HttpHeaders headers = new HttpHeaders();
        String requestId = MDC.get("REQUEST_UUID");
        if (requestId != null) {
            headers.set("Trace-UUID", requestId);
        }
        HttpEntity<String> request = new HttpEntity<String>(headers);
        System.err.println(url);
        HttpEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
        return response.getBody();

    }
}