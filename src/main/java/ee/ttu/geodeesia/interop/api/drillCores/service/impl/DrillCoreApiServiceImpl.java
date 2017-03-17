package ee.ttu.geodeesia.interop.api.drillCores.service.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.search.FluentDrillCoreSearchApiBuilder;
import ee.ttu.geodeesia.interop.api.builder.search.FluentPhotoArchiveSearchApiBuilder;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreEntity;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geodeesia.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveEntity;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;
import ee.ttu.geodeesia.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrillCoreApiServiceImpl implements DrillCoreApiService{
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
                .build();
        return apiService.searchEntities("drillcore",
                searchCriteria.getPage(),
                searchCriteria.getSortField(),
                requestParams,
                DrillCoreEntity.class);

    }
}