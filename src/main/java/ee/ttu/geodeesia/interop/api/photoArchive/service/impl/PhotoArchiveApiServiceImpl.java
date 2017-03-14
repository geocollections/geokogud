package ee.ttu.geodeesia.interop.api.photoArchive.service.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiSearchBuilder;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveEntity;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;
import ee.ttu.geodeesia.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoArchiveApiServiceImpl implements PhotoArchiveApiService{
    @Autowired
    private ApiService apiService;

    //https://api.arendus.geokogud.info/image/?paginate_by=30&order_by=id&page=1&format=json&filename__isnull=false
    @Override
    public Response findPhoto(PhotoArchiveSearchCriteria searchCriteria) {
        String requestParams = FluentGeoApiSearchBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryFileName(searchCriteria.getFileName()).andReturn()
                .queryAuthorAgent(searchCriteria.getAuthorAgent()).andReturn()
                .queryDateTaken(searchCriteria.getDateTaken()).andReturn()
                .build();
        return apiService.searchEntities("image", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, PhotoArchiveEntity.class);

    }
}