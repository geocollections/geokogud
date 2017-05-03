package ee.ttu.geocollection.interop.api.localities.service.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentLocalityImageSearchApiBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentLocalitySearchApiBuilder;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityMapFilter;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;
import ee.ttu.geocollection.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class LocalitiesApiServiceImpl implements LocalitiesApiService {

    public static final String LOCALITY_TABLE = "locality";

    @Value("${geo-api.url}")
    private String apiUrl;

    @Autowired
    private ApiService apiService;
    @Autowired
    private IndexingProperties indexingProperties;

    @Override
    public ApiResponse findLocality(LocalitySearchCriteria searchCriteria)  {
        String requestParams = prepareCommonFields(searchCriteria)
                .queryId(searchCriteria.getId())
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(
                LOCALITY_TABLE,
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams);
    }

    private FluentLocalitySearchApiBuilder prepareCommonFields(LocalitySearchCriteria searchCriteria) {
        return FluentLocalitySearchApiBuilder.aRequest()
                .queryNumber(searchCriteria.getNumber())
                .queryStratigraphy(searchCriteria.getStratigraphy())
//                .queryReference(searchCriteria.getReference()).andReturn()
                .queryMaId(searchCriteria.getMaId())
                .queryLocality(searchCriteria.getLocality())
                .queryCountry(searchCriteria.getCountry())
                .queryAdminUnit(searchCriteria.getAdminUnit())
                .queryLongitude(searchCriteria.getLatitude())
                .queryLongitude(searchCriteria.getLongitude())
                .queryDepth(searchCriteria.getVerticalExtentSince())
                .queryDepth(searchCriteria.getVerticalExtentTo());
    }

    @Override
    public ApiResponse findLocalityImage(LocalitySearchCriteria searchCriteria) {
        String requestParams = FluentLocalityImageSearchApiBuilder.aRequest()
                .queryLocalityIdForUrl(searchCriteria.getId()).andReturn()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("image", searchCriteria.getPage(),new SortField(), requestParams);
    }


    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("image")
                .relatedData("drillcore")
                .relatedData("locality_reference")
                .relatedData("locality_synonym")
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity(LOCALITY_TABLE, requestParams);
    }

    @Override
    public Map findLocalitiesSummary() {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .buildWithDefaultReturningFields() + "?format=json";
        return apiService.findRawEntity("locality_summary", requestParams);
    }

    @Override
    public Map findLocalitiesSummaryFilter(LocalityMapFilter filters) {
        String requestParams =  FluentGeoApiDetailsBuilder.aRequest().buildWithDefaultReturningFields()+"?";
        if(filters.getFilters().size() > 0) {
            for(String filter: filters.getFilters()) {
                    requestParams += filter + "__gt=0&";
            }
        }
        if(filters.getLocalityName() != "") {
            requestParams += "multi_search=value:" +  filters.getLocalityName() +
                    ";fields:name,name_en;lookuptype:icontains&";
        }
        requestParams += "format=json";
        return apiService.findRawEntity("locality_summary", requestParams);
    }

    @Override
    public ApiResponse findLocalitiesForIndex(LocalitySearchCriteria searchCriteria) {
        String requestParams = FluentLocalitySearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryNumber(searchCriteria.getNumber()).andReturn()
                .queryLocality(searchCriteria.getLocality()).andReturn()
                .returnLocalitySynonym()
                .returnDateChanged()
                .buildFullQuery();
        return apiService.searchRawEntities(
                LOCALITY_TABLE, indexingProperties.getIndexingBatchSize(), searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findLocalitiesByIds(Collection<String> ids) {
        String requestParams = prepareCommonFields(new LocalitySearchCriteria())
                .queryMultipleIds(ids).andReturn()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(LOCALITY_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }
}
