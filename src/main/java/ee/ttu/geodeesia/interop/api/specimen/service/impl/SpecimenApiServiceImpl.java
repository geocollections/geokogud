package ee.ttu.geodeesia.interop.api.specimen.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.Response.ResponseMapper;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiBuilder;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenEntity;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geodeesia.interop.api.specimen.service.SpecimenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SpecimenApiServiceImpl implements SpecimenApiService {
    @Value("${geo-api.url}")
    private String apiUrl;
    @Autowired
    private ResponseMapper responseMapper;

    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public Response findSpecimen(SpecimenSearchCriteria searchCriteria) {
        String requestParams = FluentGeoApiBuilder.aRequest()
                .withId(searchCriteria.getId())
                .withSpecimenNumber(searchCriteria.getSpecimenNumber())
                .build();
        String url = apiUrl + "/" + "specimen/" + "?paginate_by=" + 30 + "&page=" + searchCriteria.getPage()
                + "&format=" + "json" + requestParams;
        ResponseEntity<ApiResponse> rawResponse = restTemplate.getForEntity(url, ApiResponse.class);

        Response response = new Response();

        ObjectMapper mapper = new ObjectMapper();
        response.setResult(
                mapper.convertValue(
                        rawResponse.getBody().getResult(),
                        mapper.getTypeFactory().constructCollectionType(List.class, SpecimenEntity.class)));

        response.setCount(rawResponse.getBody().getCount());
        response.setCurrentPage(Integer.parseInt(rawResponse.getBody().getPageInfo().split("\\s")[1])); //Page 1 of 39
        response.setNumberOfPages(Integer.parseInt(rawResponse.getBody().getPageInfo().split("\\s")[3]));

        System.err.println(rawResponse.getBody().getPageInfo());

        return response;
    }
}
