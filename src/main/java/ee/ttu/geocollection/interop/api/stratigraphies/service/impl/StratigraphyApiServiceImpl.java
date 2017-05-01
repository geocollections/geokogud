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

import java.util.List;
import java.util.Map;

@Service
public class StratigraphyApiServiceImpl implements StratigraphyApiService {
    public static final String STRATIGRAPHY_TABLE = "stratigraphy";
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
                .buildWithDefaultReturningFields();
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
                .queryMultipleIds(ids)
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(STRATIGRAPHY_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }

}
