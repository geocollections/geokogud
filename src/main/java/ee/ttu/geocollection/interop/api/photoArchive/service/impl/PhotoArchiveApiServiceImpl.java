package ee.ttu.geocollection.interop.api.photoArchive.service.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentPhotoArchiveSearchApiBuilder;
import ee.ttu.geocollection.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;
import ee.ttu.geocollection.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PhotoArchiveApiServiceImpl implements PhotoArchiveApiService{
    public static final String IMAGE_TABLE = "image";
    private List<String> fields = Arrays.asList(
            "id",
            "filename",
            "date_taken",
            "author__agent",
            "locality_id",
            "author__forename",
            "author__surename",
            "author_free",
            "locality__locality",
            "locality__locality_en",
            "locality__country__value",
            "locality__country__value_en",
            "locality__maakond__maakond",
            "locality__vald__vald",
            "locality__asustusyksus__asustusyksus",
            "locality__maakond__maakond_en",
            "locality__vald__vald_en",
            "locality__asustusyksus__asustusyksus_en",
            "people",
            "keywords",
            "description",
            "object",
            "place",
            "image_number",
            "imageset__imageset_number",
            "imageset__imageset_series",
            "size_x",
            "size_y",
            "date_taken_free",
            "category__value",
            "category__value_en",
            "type__value",
            "type__value_en",
            "device__name",
            "copyright_agent__agent",
            "licence__licence_en",
            "licence__licence_url_en",
            "date_added",
            "date_changed",
            "user_added",
            "user_changed",
            "database__acronym"
    );

    @Autowired
    private IndexingProperties indexingProperties;
    @Autowired
    private ApiService apiService;

    //https://api.arendus.geokogud.info/image/?paginate_by=30&order_by=id&page=1&format=json&filename__isnull=false
    @Override
    public ApiResponse findPhoto(PhotoArchiveSearchCriteria searchCriteria)  {
        String requestParams = prepareCommonFields(searchCriteria)
                .queryId(searchCriteria.getId())
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(IMAGE_TABLE, searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    private FluentPhotoArchiveSearchApiBuilder prepareCommonFields(PhotoArchiveSearchCriteria searchCriteria) {
        return FluentPhotoArchiveSearchApiBuilder.aRequest()
                .groupById()
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
                .queryInstitutions(searchCriteria.getDbs());
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
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
        String requestParams = prepareCommonFields(new PhotoArchiveSearchCriteria())
                .queryMultipleIds(ids).andReturn()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities(IMAGE_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }
}