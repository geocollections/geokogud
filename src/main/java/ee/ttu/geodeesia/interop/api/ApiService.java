package ee.ttu.geodeesia.interop.api;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.*;
import ee.ttu.geodeesia.search.domain.SampleSearch;
import ee.ttu.geodeesia.search.domain.SearchField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

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

    public Response searchSampleList(SampleSearch search) {
        SearchApiRequest request = new SearchApiRequest();
        request.setPage(search.getPage());
        request.setFieldsParams(composeFieldQuery(search));
        return searchSampleList(request);
    }
    public Response searchSampleList(SearchApiRequest request) {
        String url = apiUrl + "/sample?paginate_by="+request.getNumberOfRecordsPerPage()+"&page="+request.getPage()
                +"&format=" + request.getOutputFormat() + request.getFieldsParams();
        logger.info(url);
        ResponseEntity<SampleApiResponse> response = restTemplate.getForEntity(url, SampleApiResponse.class);
        Response response_ = new Response();
        response_.setResult(response.getBody().toResponseEntities());
        response_.setCount(response.getBody().getCount());
        System.err.println(response.getBody().getPageInfo());
        response_.setCurrentPage(Integer.parseInt(response.getBody().getPageInfo().split("\\s")[1])); //Page 1 of 39
        response_.setNumberOfPages(Integer.parseInt(response.getBody().getPageInfo().split("\\s")[3]));
        return  response_;
    }

    private boolean isNotNullAndEmpty(SearchField field) {
        return field != null && field.getName() != null && !field.getName().equals("");
    }
    private String composeFieldQuery( SampleSearch search) {
        String fieldsParams = "";
        if(isNotNullAndEmpty(search.getId())) {
            fieldsParams += "&id__"+search.getId().getLookUpType().value()+"="+search.getId().getName();
        }
        if(isNotNullAndEmpty(search.getSampleNumber())) {
            fieldsParams += "&sample_number__"+search.getSampleNumber().getLookUpType().value()+"="+search.getSampleNumber().getName();
        }
        if(isNotNullAndEmpty(search.getLocality())) {
            fieldsParams += "&locality__"+search.getLocality().getLookUpType().value()+"="+search.getLocality().getName();
        }
        if(isNotNullAndEmpty(search.getCountry())) {
            fieldsParams += "&country__"+search.getCountry().getLookUpType().value()+"="+search.getCountry().getName();
        }
        if(isNotNullAndEmpty(search.getDepth())) {
            fieldsParams += "&depth__"+search.getDepth().getLookUpType().value()+"="+search.getDepth().getName();
        }
        if(isNotNullAndEmpty(search.getStratigraphy())) {
            fieldsParams += "&stratigraphy__"+search.getStratigraphy().getLookUpType().value()+"="+search.getStratigraphy().getName();
        }
        if(isNotNullAndEmpty(search.getStratigraphyBed())) { fieldsParams += "&stratigraphyBed__"+search.getStratigraphyBed().getLookUpType().value()+"="+search.getStratigraphyBed().getName();}
        if(isNotNullAndEmpty(search.getAgent())) { fieldsParams += "&agent__"+search.getAgent().getLookUpType().value()+"="+search.getAgent().getName();}
        if(isNotNullAndEmpty(search.getMass())) { fieldsParams += "&mass__"+search.getMass().getLookUpType().value()+"="+search.getMass().getName();}
        if(isNotNullAndEmpty(search.getLocation())) { fieldsParams += "&location__"+search.getLocation().getLookUpType().value()+"="+search.getLocation().getName();}
        if(isNotNullAndEmpty(search.getTaxon())) { fieldsParams += "&taxon__"+search.getTaxon().getLookUpType().value()+"="+search.getTaxon().getName();}
        if(isNotNullAndEmpty(search.getFrequency())) { fieldsParams += "&frequency__"+search.getFrequency().getLookUpType().value()+"="+search.getFrequency().getName();}
        if(isNotNullAndEmpty(search.getAnalysis())) { fieldsParams += "&analysis__"+search.getAnalysis().getLookUpType().value()+"="+search.getAnalysis().getName();}
        if(isNotNullAndEmpty(search.getComponent())) { fieldsParams += "&component__"+search.getComponent().getLookUpType().value()+"="+search.getComponent().getName();}
        if(isNotNullAndEmpty(search.getContent())) { fieldsParams += "&content__"+search.getContent().getLookUpType().value()+"="+search.getContent().getName();}
        if(!search.getDbs().isEmpty()) { fieldsParams += "&database__acronym="+search.getDbs().stream().collect(Collectors.joining(","));}
        return fieldsParams;
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
