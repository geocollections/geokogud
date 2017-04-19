package ee.ttu.geocollection.interop.api.samples.service.impl;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentSampleSearchApiBuilder;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class SamplesApiServiceImpl implements SamplesApiService {

    @Value("${geo-api.url}")
    private String apiUrl;
    @Autowired
    private ApiService apiService;

    private static final Logger logger = LoggerFactory.getLogger(SamplesApiServiceImpl.class);

    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public ApiResponse findSample(ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria searchCriteria)
            throws AppException {
        System.err.println(searchCriteria.getId());
        String requestParams = FluentSampleSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryNumber(searchCriteria.getSampleNumber()).andReturn()
                .queryLocality(searchCriteria.getLocality()).andReturn()
                .queryCountry(searchCriteria.getCountry())
                .queryDepth(searchCriteria.getDepthSince()).andReturn()
                .queryDepth(searchCriteria.getDepthTo())
                .queryStratigraphy(searchCriteria.getStratigraphy()).andReturn()
                .queryStratigraphyBed(searchCriteria.getStratigraphyBed())
                .queryAgent(searchCriteria.getAgent()).andReturn()
                .queryMass(searchCriteria.getMassSince()).andReturn()
                .queryMass(searchCriteria.getMassTo())
                .queryLocation(searchCriteria.getLocation())
                .queryTaxon(searchCriteria.getTaxon())
                .queryFrequency(searchCriteria.getFrequency())
                .queryAnalysisMethod(searchCriteria.getAnalysisMethod())
                .queryComponet(searchCriteria.getComponent())
                .queryContent(searchCriteria.getContent())
                .queryInstitutions(searchCriteria.getDbs()).andReturn()
                .returnAnalyzed()
                .buildFullQuery();
        return apiService.searchRawEntities(
                "sample",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams);
    }

    @Override
    public Map findRawById(Long id) throws AppException{
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("analysis")
                .relatedData("analysis_results")
                .relatedData("preparation")
                .relatedData("taxon_list")
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("sample", requestParams);
    }

}
