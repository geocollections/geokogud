package ee.ttu.geocollection.interop.api.drillCores.service.impl;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentDrillCoreSearchApiBuilder;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geocollection.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DrillCoreApiServiceImpl implements DrillCoreApiService {
    @Autowired
    private ApiService apiService;

    //https://api.arendus.geokogud.info/drillcore/?paginate_by=30&order_by=id&page=1&format=json
    @Override
    public ApiResponse findDrillCore(DrillCoreSearchCriteria searchCriteria) throws AppException {
        String requestParams = FluentDrillCoreSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .queryDrillCore(searchCriteria.getDrillcore())
                .queryBoxNumber(searchCriteria.getBoxNumber())
                .queryStorageLocation(searchCriteria.getStorage())
                //following fields is not possible to set via search but we can ask from API
                //locality__country__value,locality__country__value_en,locality__latitude,
                //locality__longitude,depth,boxes
                .queryLocalityCountry(searchCriteria.getCountry())

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
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("drillcore_box")
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("drillcore", requestParams);
    }
}