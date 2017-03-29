package ee.ttu.geodeesia.interop.api.drillCores.service.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geodeesia.interop.api.builder.search.FluentDrillCoreSearchApiBuilder;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreEntity;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geodeesia.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrillCoreApiServiceImpl implements DrillCoreApiService {
    @Autowired
    private ApiService apiService;

    //https://api.arendus.geokogud.info/drillcore/?paginate_by=30&order_by=id&page=1&format=json
    @Override
    public Response findDrillCore(DrillCoreSearchCriteria searchCriteria) {
        String requestParams = FluentDrillCoreSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryDrillCore(searchCriteria.getDrillcore()).andReturn()
                .queryBoxNumber(searchCriteria.getBoxNumber()).andReturn()
                .queryStorageLocation(searchCriteria.getStorage()).andReturn()
                //following fields is not possible to set via search but we can ask from API
                //locality__country__value,locality__country__value_en,locality__latitude,
                //locality__longitude,depth,boxes
                .queryLocalityCountry(searchCriteria.getLocalityCountry()).andReturn()

                .queryLocalityCountry(searchCriteria.getLocalityCountry()).andReturn()
                .queryLocalityCountryEng(searchCriteria.getLocalityCountryEng()).andReturn()
                .queryLocalityLatitude(searchCriteria.getLatitude()).andReturn()
                .queryLocalityLongitude(searchCriteria.getLongitude()).andReturn()
                .queryBoxes(searchCriteria.getBoxes()).andReturn()
                .queryDepth(searchCriteria.getDepth()).andReturn()
                .queryInstitution(searchCriteria.getDbs()).andReturn()
                .build();
        return apiService.searchEntities("drillcore",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams,
                DrillCoreEntity.class);
    }

    @Override
    public Response findById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .build();
        //return apiService.findEntityAndMagicallyDeserialize("drillcore", requestParams, DrillCoreProto.class);
        return apiService.findEntity("drillcore", requestParams, DrillCoreEntity.class);
    }
}