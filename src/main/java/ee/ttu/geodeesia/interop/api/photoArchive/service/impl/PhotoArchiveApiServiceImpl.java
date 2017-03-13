package ee.ttu.geodeesia.interop.api.photoArchive.service.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiBuilder;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiApiResponse;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiSearchCriteria;
import ee.ttu.geodeesia.interop.api.doi.service.DoiApiService;
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
        String requestParams = FluentGeoApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryFileName(searchCriteria.getFileName()).andReturn()
                .queryAuthorAgent(searchCriteria.getAuthorAgent()).andReturn()
                .queryDateTaken(searchCriteria.getDateTaken()).andReturn()
                .build();
        return apiService.findEntity("image", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, PhotoArchiveEntity.class);

    }
}