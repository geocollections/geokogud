package ee.ttu.geocollection.interop.api.photoArchive.service.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentLocalitySearchApiBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentPhotoArchiveSearchApiBuilder;
import ee.ttu.geocollection.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;
import ee.ttu.geocollection.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhotoArchiveApiServiceImpl implements PhotoArchiveApiService{
    public static final String IMAGE_TABLE = "image";
    @Autowired
    private IndexingProperties indexingProperties;
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
        return apiService.searchRawEntities(IMAGE_TABLE, searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);

    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity(IMAGE_TABLE, requestParams);
    }

    @Override
    public ApiResponse findImagesForIndex(PhotoArchiveSearchCriteria searchCriteria) {
        String requestParams = FluentPhotoArchiveSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .queryNumber(searchCriteria.getImageNumber()).andReturn()
                .queryKeywords(searchCriteria.getKeywords()).andReturn()
                .returnDateChanged()
                .buildFullQuery();
        return apiService.searchRawEntities(IMAGE_TABLE, indexingProperties.getIndexingBatchSize(), searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findImagesByIds(List<String> ids) {
        String requestParams = FluentLocalitySearchApiBuilder.aRequest()
                .queryMultipleIds(ids)
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(IMAGE_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }
}