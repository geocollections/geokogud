package ee.ttu.geocollection.interop.api.drillCores.service.impl;

import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentDrillCoreImageSearchApiBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentDrillCoreSearchApiBuilder;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geocollection.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class DrillCoreApiServiceImpl implements DrillCoreApiService {
    @Autowired
    private ApiService apiService;
    private List<String> fields = Arrays.asList(
        "id",
        "drillcore",
        "locality__country__value",
        "locality__country__value_en",
        "locality__latitude",
        "locality__longitude",
        "depth",
        "boxes",
        "box_numbers",
        "storage__location",
        "locality_id",
        "drillcore_en",
        "depository__value",
        "depository__value_en",
        "number_meters",
        "year",
        "remarks",
        "agent__agent",
        "database__acronym",
        "locality__maaamet_pa_id",
        "locality__locality",
        "locality__locality_en"
    );

    //https://api.arendus.geokogud.info/drillcore/?paginate_by=30&order_by=id&page=1&format=json
    @Override
    public ApiResponse findDrillCore(DrillCoreSearchCriteria searchCriteria)  {
        String requestParams = FluentDrillCoreSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .groupById()
                .queryDrillCore(searchCriteria.getDrillcore())
                .queryBoxNumber(searchCriteria.getBoxNumber())
                .queryStorageLocation(searchCriteria.getStorage())
                .queryLocalityAdminUnit(searchCriteria.getAdminUnit())
                .queryLocalityCountry(searchCriteria.getCountry())
                .queryStratigraphy(searchCriteria.getStratigraphy())
                .queryLocalityLatitude(searchCriteria.getLatitude())
                .queryLocalityLongitude(searchCriteria.getLongitude())
                .queryBoxes(searchCriteria.getBoxesSince())
                .queryBoxes(searchCriteria.getBoxesTo())
                .queryDepth(searchCriteria.getDepth())
                .queryInstitutions(searchCriteria.getDbs())
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("drillcore", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }


    @Override
    public ApiResponse findDrillCoreImage(SearchField drillCoreId) {
        String requestParams = FluentDrillCoreImageSearchApiBuilder.aRequest()
                .querySpecimenIdForUrl(drillCoreId)
                .returnImageUrl()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("drillcore_image", 2,1, new SortField(), requestParams);
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("drillcore_box")
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
        return apiService.findRawEntity("drillcore", requestParams);
    }
    @Override
    public Map findRawCoreBoxById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("drillcore_box", requestParams);
    }
}