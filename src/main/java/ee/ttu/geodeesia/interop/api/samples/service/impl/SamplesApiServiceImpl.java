package ee.ttu.geodeesia.interop.api.samples.service.impl;

import ee.ttu.geodeesia.interop.api.Request.SampleSearchCriteria;
import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.NewVersionOfApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.Response.ResponseMapper;
import ee.ttu.geodeesia.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geodeesia.interop.api.builder.search.FluentSampleSearchApiBuilder;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleEntity;
import ee.ttu.geodeesia.interop.api.samples.service.SamplesApiService;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import ee.ttu.geodeesia.search.domain.CommonSearch;
import ee.ttu.geodeesia.search.domain.SearchField;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class SamplesApiServiceImpl implements SamplesApiService {

    @Value("${geo-api.url}")
    private String apiUrl;
    @Autowired
    private ResponseMapper responseMapper;
    @Autowired
    private ApiService apiService;

    private static final Logger logger = LoggerFactory.getLogger(SamplesApiServiceImpl.class);

    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public Response findSample(ee.ttu.geodeesia.interop.api.samples.pojo.SampleSearchCriteria searchCriteria) {
        String requestParams = FluentSampleSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryNumber(searchCriteria.getSampleNumber()).andReturn()
                .queryStratigraphy(searchCriteria.getStratigraphy()).andReturn()
                .queryStratigraphyBed(searchCriteria.getStratigraphyBed()).andReturn()
                .queryLocation(searchCriteria.getLocation()).andReturn()
                .queryMass(searchCriteria.getMass()).andReturn()
                .queryAgent(searchCriteria.getAgent()).andReturn()
             /*   .queryTaxon(searchCriteria.getTaxon()).andReturn()
                .queryAnalysis(searchCriteria.getAnalysis()).andReturn()
                .queryFrequency(searchCriteria.getFrequency()).andReturn()
                .queryComponet(searchCriteria.getComponent()).andReturn()
                .queryContent(searchCriteria.getContent()).andReturn()*/
                .queryInstitution(searchCriteria.getDbs()).andReturn()
                .buildWithoutReturningCertainFields();
        return apiService.searchEntities("sample",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams,
                SampleEntity.class);
    }

    @Override
    public Response findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findEntity("sample", requestParams, SampleEntity.class);
    }


    @Override
    public Response searchByParam(String q, String table) {
        SearchApiRequest request = new SearchApiRequest();
        request.setField(table);
        request.setSearchCriteria("istartswith");//?Start with or contains?
        return searchList(request);
    }


    @Override
    public Response searchList(CommonSearch search) {
        SearchApiRequest request = new SearchApiRequest();
        request.setTable(search.getTable());
        request.setPage(search.getPage());
        request.setOrderBy(search.getOrderBy());
        request.setSortAsc(search.getSortAsc());
        request.setFieldsParams(composeFieldQuery(search));
        return searchList(request);
    }

    @Override
    public Response searchList(SearchApiRequest request) {
        System.err.print(request.getTable());
        Response response_ = new Response();
        if (request.getTable() == null) return response_;
        String url = apiUrl + "/" + request.getTable()
                + "?paginate_by=" + request.getNumberOfRecordsPerPage()
                + "&order_by=" + getSortDir(request.getSortAsc()) + request.getOrderBy()
                + "&page=" + request.getPage()
                + "&format=" + request.getOutputFormat() + request.getFieldsParams();
        logger.info(url);
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);

        response_.setResult(responseMapper.toResponseEntities(request.getTable(), response.getBody().getResult()));
        response_.setCount(response.getBody().getCount());
        System.err.println(response.getBody().getPageInfo());
        if (response.getBody().getPageInfo() != null) {
            response_.setCurrentPage(Integer.parseInt(response.getBody().getPageInfo().split("\\s")[1])); //Page 1 of 39
            response_.setNumberOfPages(Integer.parseInt(response.getBody().getPageInfo().split("\\s")[3]));
        }
        return response_;
    }

    private String getSortDir(boolean sortAsc) {
        return sortAsc ? "" : "-";
    }

    @Override
    public NewVersionOfApiResponse getEntityInfo(String entity, Long id) {
        SearchApiRequest request = new SearchApiRequest();
        request.setTable(entity);
        return getEntityInfo(id, request);
    }

    @Override
    public NewVersionOfApiResponse getEntityInfo(Long id, SearchApiRequest request) {
        if (request.getTable() == null) return new NewVersionOfApiResponse();
        String url = apiUrl + "/" + request.getTable() + "/" + id + "?format=" + request.getOutputFormat();
        logger.info(url);
        ResponseEntity<NewVersionOfApiResponse> response = restTemplate.getForEntity(url, NewVersionOfApiResponse.class);
        NewVersionOfApiResponse apiResponse = response.getBody();
        //TODO:Analyze is it dangerous
        apiResponse.setResults(responseMapper.toResponseEntities(request.getTable(), apiResponse.getResults()));
        return apiResponse;
    }

    @Override
    public Response searchSamples(SampleSearchCriteria criteria) {
        String requestParams = FluentSampleSearchApiBuilder.aRequest()
                .queryId(criteria.getId()).andReturn()
                .queryDepth(criteria.getDepth()).andReturn()
                .querySoilSiteId(criteria.getSoilSiteId())
                .returnNumberAdditional()
                .returnDepthInterval()
                .returnRemarks()
                .build();
        return apiService.searchEntities("sample", criteria.getPage(), criteria.getSortField(), requestParams, SampleEntity.class);
    }

    private String composeFieldQuery(CommonSearch search) {
        String fieldsParams = "";
        if (isNotNullAndEmpty(search.getId())) {
            fieldsParams += "&id__" + search.getId().getLookUpType().value() + "=" + search.getId().getName();
        }
        if (isNotNullAndEmpty(search.getSampleNumber())) {
            fieldsParams += "&number__" + search.getSampleNumber().getLookUpType().value() + "=" + search.getSampleNumber().getName();
        }
        if (isNotNullAndEmpty(search.getLocality())) {
            if (search.getTable().equals("sample")) {
                fieldsParams += "&locality__locality__" + search.getLocality().getLookUpType().value() + "=" + search.getLocality().getName();
            } else {
                fieldsParams += "&locality__" + search.getLocality().getLookUpType().value() + "=" + search.getLocality().getName();
            }
        }
        if (isNotNullAndEmpty(search.getCountry())) {
            if (search.getTable().equals("sample")) {
                fieldsParams += "&locality__country__value__" + search.getLocality().getLookUpType().value() + "=" + search.getLocality().getName();
            } else {
                fieldsParams += "&country__" + search.getCountry().getLookUpType().value() + "=" + search.getCountry().getName();
            }
        }
        if (isNotNullAndEmpty(search.getDepth())) {
            fieldsParams += "&depth__" + search.getDepth().getLookUpType().value() + "=" + search.getDepth().getName();
        }
        if (isNotNullAndEmpty(search.getStratigraphy())) {
            if (search.getTable().equals("sample")) {
                fieldsParams += "&stratigraphy__stratigraphy__" + search.getStratigraphy().getLookUpType().value() + "=" + search.getStratigraphy().getName();
            } else {
                fieldsParams += "&stratigraphy__" + search.getStratigraphy().getLookUpType().value() + "=" + search.getStratigraphy().getName();
            }
        }
        if (isNotNullAndEmpty(search.getStratigraphyBed())) {
            fieldsParams += "&stratigraphy_bed__" + search.getStratigraphyBed().getLookUpType().value() + "=" + search.getStratigraphyBed().getName();
        }
        if (isNotNullAndEmpty(search.getAgent())) {
            fieldsParams += "&agent__" + search.getAgent().getLookUpType().value() + "=" + search.getAgent().getName();
        }
        if (isNotNullAndEmpty(search.getMass())) {
            fieldsParams += "&mass__" + search.getMass().getLookUpType().value() + "=" + search.getMass().getName();
        }
        if (isNotNullAndEmpty(search.getLocation())) {
            fieldsParams += "&location__" + search.getLocation().getLookUpType().value() + "=" + search.getLocation().getName();
        }
        if (isNotNullAndEmpty(search.getTaxon())) {
            fieldsParams += "&taxon__" + search.getTaxon().getLookUpType().value() + "=" + search.getTaxon().getName();
        }
        if (isNotNullAndEmpty(search.getFrequency())) {
            fieldsParams += "&frequency__" + search.getFrequency().getLookUpType().value() + "=" + search.getFrequency().getName();
        }
        if (isNotNullAndEmpty(search.getAnalysis())) {
            fieldsParams += "&analysis__" + search.getAnalysis().getLookUpType().value() + "=" + search.getAnalysis().getName();
        }
        if (isNotNullAndEmpty(search.getComponent())) {
            fieldsParams += "&component__" + search.getComponent().getLookUpType().value() + "=" + search.getComponent().getName();
        }
        if (isNotNullAndEmpty(search.getContent())) {
            fieldsParams += "&content__" + search.getContent().getLookUpType().value() + "=" + search.getContent().getName();
        }
        if (!search.getDbs().isEmpty()) {
            fieldsParams += "&database__acronym=" + search.getDbs().stream().collect(Collectors.joining("&database__acronym="));
        }
        return fieldsParams;
    }

    private boolean isNotNullAndEmpty(SearchField field) {
        return field != null && StringUtils.isNotBlank(field.getName());
    }
}
