package ee.ttu.geocollection.interop.api.stratigraphies.service.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentStratigraphySearchApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;
import ee.ttu.geocollection.interop.api.stratigraphies.service.StratigraphyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class StratigraphyApiServiceImpl implements StratigraphyApiService {
    public static final String STRATIGRAPHY_TABLE = "stratigraphy";
    private List<String> fields = Arrays.asList(
        "id",
        "stratigraphy",
        "stratigraphy_en",
        "type__value",
        "type__value_en",
        "rank__value",
        "rank__value_en",
        "scope__value",
        "scope__value_en",
        "status__value",
        "status__value_en",
        "index_main",
        "index_additional",
        "index_main_html",
        "index_additional_html",
        "parent__stratigraphy",
        "parent__stratigraphy_en",
        "age_base",
        "age_top",
        "age_chronostratigraphy__stratigraphy",
        "age_chronostratigraphy__stratigraphy_en",
        "age_reference__reference",
        "etymon",
        "etymon_en",
        "region",
        "region_en",
        "original_locality",
        "max_thickness",
        "remarks",
        "year",
        "color_code_cgmw",
        "lithology",
        "lithology_en",
        "author_free"
    );

    @Autowired
    private IndexingProperties indexingProperties;
    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findStratigraphy(StratigraphySearchCriteria searchCriteria)  {
        String requestParams = prepareCommonFields(searchCriteria)
                .queryId(searchCriteria.getId())
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(
                STRATIGRAPHY_TABLE,
                    searchCriteria.getPage(),
                    searchCriteria.getSortField(),
                    requestParams);
    }

    private FluentStratigraphySearchApiBuilder prepareCommonFields(StratigraphySearchCriteria searchCriteria) {
        return FluentStratigraphySearchApiBuilder.aRequest()
                .queryStratigraphy(searchCriteria.getStratigraphy())
                .queryIndex(searchCriteria.getIndex())
                .queryAgeBase(searchCriteria.getAgeMinY())
                .queryLithology(searchCriteria.getMainLithology())
                .queryAuthor(searchCriteria.getAuthor());
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("stratigraphy_reference")
                .relatedData("stratigraphy_stratotype")
                .relatedData("stratigraphy_synonym")
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
        return apiService.findRawEntity(STRATIGRAPHY_TABLE, requestParams);
    }

    @Override
    public ApiResponse findStratigraphyForIndex(StratigraphySearchCriteria searchCriteria) {
        String requestParams = FluentStratigraphySearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryStratigraphy(searchCriteria.getStratigraphy()).andReturn()
                .queryIndex(searchCriteria.getIndex()).andReturn()
                .queryParentStratigraphy(null).andReturn()
                .queryAgeChronostratigraphy(null).andReturn()
                .returnDateChanged()
                .buildFullQuery();
        return apiService.searchRawEntities(STRATIGRAPHY_TABLE, indexingProperties.getIndexingBatchSize(), searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findStratigraphyByIds(List<String> ids) {
        String requestParams = prepareCommonFields(new StratigraphySearchCriteria())
                .queryMultipleIds(ids).andReturn()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(STRATIGRAPHY_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }

}
