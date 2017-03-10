package ee.ttu.geodeesia.interop.api.soil.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.Response.ResponseMapper;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiBuilder;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SoilApiServiceImpl implements SoilApiService {
    @Value("${geo-api.url}")
    private String apiUrl;
    @Autowired
    private ResponseMapper responseMapper;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Response findSoil(SoilSearchCriteria searchCriteria) {
        String requestParams = FluentGeoApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .querySite(searchCriteria.getSite()).andReturn()
                .queryAreaName(searchCriteria.getAreaOfStudy()).andReturn()
                .queryLandUse(searchCriteria.getLandUse()).andReturn()
                .querySoil(searchCriteria.getSoilName()).andReturn()
                .queryTransect(searchCriteria.getTransect()).andReturn()
                .queryDeepMining(searchCriteria.getDeepMining()).andReturn()
                .returnLatitude()
                .returnLongitude()
                .returnTransectPoint()
                .build();
        String url = apiUrl + "/" + "soil_site/" + "?paginate_by=" + 30 + "&page=" + searchCriteria.getPage()
                + "&format=" + "json" + requestParams;
        ResponseEntity<ApiResponse> rawResponse = restTemplate.getForEntity(url, ApiResponse.class);

        Response response = new Response();

        ObjectMapper mapper = new ObjectMapper();
        response.setResult(
                mapper.convertValue(
                        rawResponse.getBody().getResult(),
                        mapper.getTypeFactory().constructCollectionType(List.class, SoilApiResponse.class)));

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
}