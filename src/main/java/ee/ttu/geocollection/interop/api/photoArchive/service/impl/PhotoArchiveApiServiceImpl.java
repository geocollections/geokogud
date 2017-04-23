package ee.ttu.geocollection.interop.api.photoArchive.service.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentPhotoArchiveSearchApiBuilder;
import ee.ttu.geocollection.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;
import ee.ttu.geocollection.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PhotoArchiveApiServiceImpl implements PhotoArchiveApiService{
    @Autowired
    private ApiService apiService;

    //https://api.arendus.geokogud.info/image/?paginate_by=30&order_by=id&page=1&format=json&filename__isnull=false
    @Override
    public ApiResponse findPhoto(PhotoArchiveSearchCriteria searchCriteria)  {
        String requestParams = FluentPhotoArchiveSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .queryFileName(searchCriteria.getFileName())
                .queryAuthorAgent(searchCriteria.getAuthorAgent())
                .queryDateTaken(searchCriteria.getDateTakenSince())
                .queryDateTaken(searchCriteria.getDateTakenTo())
                .queryKeywords(searchCriteria.getKeywords())
                .queryNumber(searchCriteria.getImageNumber())
                .queryPeople(searchCriteria.getPeople())
                .queryLocality(searchCriteria.getLocality())
                .queryCountry(searchCriteria.getAdminUnit())
                .querySize(searchCriteria.getSizeXYSince())
                .querySize(searchCriteria.getSizeXYTo())
                .queryInstitutions(searchCriteria.getDbs())
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("image", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);

    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("image", requestParams);
    }
}