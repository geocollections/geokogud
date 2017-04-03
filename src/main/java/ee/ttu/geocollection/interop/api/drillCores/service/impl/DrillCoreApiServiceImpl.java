package ee.ttu.geocollection.interop.api.drillCores.service.impl;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentDrillCoreSearchApiBuilder;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreProto;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillcoreBox;
import ee.ttu.geocollection.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrillCoreApiServiceImpl implements DrillCoreApiService {
    @Autowired
    private ApiService apiService;

    //https://api.arendus.geokogud.info/drillcore/?paginate_by=30&order_by=id&page=1&format=json
    @Override
    public Response<DrillCoreProto> findDrillCore(DrillCoreSearchCriteria searchCriteria) {
        String requestParams = FluentDrillCoreSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .queryDrillCore(searchCriteria.getDrillcore())
                .queryBoxNumber(searchCriteria.getBoxNumber())
                .queryStorageLocation(searchCriteria.getStorage())
                //following fields is not possible to set via search but we can ask from API
                //locality__country__value,locality__country__value_en,locality__latitude,
                //locality__longitude,depth,boxes
                .queryLocalityCountry(searchCriteria.getLocalityCountry())

                .queryLocalityCountry(searchCriteria.getLocalityCountry())
                .queryLocalityCountryEng(searchCriteria.getLocalityCountryEng())
                .queryLocalityLatitude(searchCriteria.getLatitude())
                .queryLocalityLongitude(searchCriteria.getLongitude())
                .queryBoxes(searchCriteria.getBoxes())
                .queryDepth(searchCriteria.getDepth())
                .queryInstitution(searchCriteria.getDbs())
                .buildWithoutReturningCertainFields();
        return apiService.searchEntitiesAngMagicallyDeserialize("drillcore",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams,
                DrillCoreProto.class);
    }

    @Override
    public DrillCoreProto findDrillcoreById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("drillcore_box")
                .buildWithDefaultReturningFields();
        return apiService.findEntityAndMagicallyDeserialize("drillcore", requestParams, DrillCoreProto.class);
    }

    @Override
    public DrillcoreBox findDrillcoreBoxById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findEntityAndMagicallyDeserialize("drillcore_box", requestParams, DrillcoreBox.class);
    }
}