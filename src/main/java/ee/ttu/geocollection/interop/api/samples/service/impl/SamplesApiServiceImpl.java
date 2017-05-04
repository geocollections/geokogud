package ee.ttu.geocollection.interop.api.samples.service.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentSampleSearchApiBuilder;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class SamplesApiServiceImpl implements SamplesApiService {
    private static final String SAMPLE_TABLE = "sample";
    private List<String> fields = Arrays.asList(
            "id",
            "number",
            "number_additional",
            "locality_id",
            "locality__locality",
            "locality__locality_en",
            "locality_free",
            "locality__latitude",
            "locality__longitude",
            "locality__country__value",
            "locality__country__value_en",
            "soil_horizon",
            "soil_site__site",
            "soil_site__site_en",
            "soil_site__latitude",
            "soil_site__longitude",
            "stratigraphy_id",
            "stratigraphy__stratigraphy",
            "stratigraphy__stratigraphy_en",
            "lithostratigraphy__stratigraphy",
            "lithostratigraphy__stratigraphy_en",
            "stratigraphy_bed",
            "agent_collected__agent",
            "agent_collected_free",
            "date_collected",
            "date_collected_free",
            "depth",
            "depth_interval",
            "classification_rock__name",
            "classification_rock__name_en",
            "rock",
            "rock_en",
            "location",
            "mass",
            "remarks",
            "series_id",
            "database__acronym",
            "date_added",
            "date_changed"
    );

    @Autowired
    private ApiService apiService;
    @Autowired
    private IndexingProperties indexingProperties;

    @Override
    public ApiResponse findSample(SampleSearchCriteria searchCriteria) {
        System.err.println(searchCriteria.getId());
        String requestParams = prepareCommonFields(searchCriteria)
                .queryId(searchCriteria.getId()).andReturn()
                .buildFullQuery();
        return apiService.searchRawEntities(
                SAMPLE_TABLE,
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams);
    }

    private FluentSampleSearchApiBuilder prepareCommonFields(SampleSearchCriteria searchCriteria) {
        return FluentSampleSearchApiBuilder.aRequest()
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
                .returnLocalityId()
                .returnDateChanged();
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
          /*      .returnId()
                .returnLocality()
                .returnLocalityEn()
                .returnNumber()
                .returnNumberAdditional()*/
//                .relatedData("analysis")
//                .relatedData("analysis_results")
//                .relatedData("preparation")
//                .relatedData("taxon_list")
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
        return apiService.findRawEntity(SAMPLE_TABLE, requestParams);
    }

    @Override
    public ApiResponse findSampleForIndex(SampleSearchCriteria searchCriteria) {
        String requestParams = FluentSampleSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryNumber(searchCriteria.getSampleNumber()).andReturn()
                .queryLocality(searchCriteria.getLocality()).andReturn()
                .returnDateChanged()
                .buildFullQuery();
        return apiService.searchRawEntities
                (SAMPLE_TABLE, indexingProperties.getIndexingBatchSize(), searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findSamplesByIds(Collection<String> ids) {
        String requestParams = prepareCommonFields(new SampleSearchCriteria())
                .queryMultipleIds(ids).andReturn()
                .buildFullQuery();
        return apiService.searchRawEntities(SAMPLE_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }

}
