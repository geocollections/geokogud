package ee.ttu.geodeesia.interop.api.doi.service.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.Response.ResponseMapper;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiBuilder;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiApiResponse;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiSearchCriteria;
import ee.ttu.geodeesia.interop.api.doi.service.DoiApiService;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import microsoft.exchange.webservices.data.core.enumeration.search.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DoiApiServiceImpl implements DoiApiService {
    @Autowired
    private ApiService apiService;

    //https://api.arendus.geokogud.info/image/?paginate_by=30&order_by=id&page=1&format=json&filename__isnull=false
    @Override
    public Response findDoi(DoiSearchCriteria searchCriteria) {
        String requestParams = FluentGeoApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryAuthor(searchCriteria.getAuthor()).andReturn()
                .queryTitle(searchCriteria.getTitle()).andReturn()
                .queryYear(searchCriteria.getYear()).andReturn()
                .queryDoi(searchCriteria.getDoi()).andReturn()
                .fieldIsNotNull("doi")
                .build();
        return apiService.findEntity("reference", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, DoiApiResponse.class);
    }
}