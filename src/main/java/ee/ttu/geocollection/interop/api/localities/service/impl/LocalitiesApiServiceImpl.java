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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class LocalitiesApiServiceImpl implements LocalitiesApiService {

    public static final String LOCALITY_TABLE = "locality";

    private List<String> fields = Arrays.asList(
            "id",
            "asustusyksus__asustusyksus_en",
            "asustusyksus__asustusyksus",
            "country__value_en",
            "country__value",
            "depth",
            "eelis",
            "elevation",
            "latitude",
            "locality_en",
            "locality",
            "longitude",
            "maaamet_pa_id",
            "maakond__maakond_en",
            "maakond__maakond",
            "number",
            "parent__locality",
            "remarks_location",
            "stratigraphy_base__stratigraphy_en",
            "stratigraphy_base__stratigraphy",
            "stratigraphy_base_id",
            "stratigraphy_top__stratigraphy_en",
            "stratigraphy_top__stratigraphy",
            "stratigraphy_top_id",
            "localitystratigraphy__stratigraphy__stratigraphy_en",
            "type__value_en",
            "type__value",
            "vald__vald_en",
            "vald__vald",
            "coord_system",
            "coordx",
            "coordy",
            "coord_det_precision__value",
            "coord_det_method__value",
            "coord_det_method__value_en",
            "coord_det_agent__agent",
            "stratigraphy_top_free",
            "stratigraphy_base_free",
            "remarks",
            "user_added",
            "date_added",
            "date_changed"
    );

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
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
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
