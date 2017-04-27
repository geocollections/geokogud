package ee.ttu.geocollection.interop.api.specimen.service.impl;

import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentSpecimenImageSearchApiBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentSpecimenSearchApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geocollection.interop.api.specimen.service.SpecimenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class SpecimenApiServiceImpl implements SpecimenApiService {
    public static final String SPECIMEN_TABLE = "specimen";
    @Autowired
    private ApiService apiService;
    @Autowired
    private IndexingProperties indexingProperties;

    @Override
    public ApiResponse findSpecimen(SpecimenSearchCriteria searchCriteria)  {
        String requestParams = FluentSpecimenSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .querySpecimenNumber(searchCriteria.getSpecimenNumber()).andReturn()
                .queryCollectionNumber(searchCriteria.getCollectionNumber()).andReturn()
                .queryClassification(searchCriteria.getClassification())
                .queryMineralRock(searchCriteria.getMineralRock())
                .queryLocality(searchCriteria.getLocality()).andReturn()
                .queryDepth(searchCriteria.getDepthSince()).andReturn()
                .queryDepth(searchCriteria.getDepthTo())
                .queryStratigraphy(searchCriteria.getStratigraphy()).andReturn()
                .queryDateAdded(searchCriteria.getRegDateStart())
                .queryDateAdded(searchCriteria.getRegDateEnd())
                .queryPartOfFossil(searchCriteria.getPartOfFossil())
                .queryOriginalStatus(searchCriteria.getTypeStatus()).andReturn()
                .queryCollector(searchCriteria.getCollector()).andReturn()
                .queryKeywords(searchCriteria.getKeyWords())
                .queryReference(searchCriteria.getReference())
                .queryNameOfFossil(searchCriteria.getFossilName()).andReturn()
                .queryFossilMineralRock(searchCriteria.getFossilMineralRock())
                .queryAdminUnit(searchCriteria.getAdminUnit())
                .queryInstitutions(searchCriteria.getDbs()).andReturn()
                .returnDatabaseName()
                .returnLocalityId()
                .returnTaxonId()
                .returnStratigraphyId()
                .returnLatitutde()
                .returnLongitude()
                .buildFullQuery();
        return apiService.searchRawEntities(SPECIMEN_TABLE, searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findSpecimenImage(SearchField specimenId) {
        String requestParams = FluentSpecimenImageSearchApiBuilder.aRequest()
                .querySpecimenIdForUrl(specimenId).andReturn()
            /*    .returnImageUrl()*/
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("specimen_image", 2,1, new SortField(), requestParams);
    }

    @Override
    public ApiResponse findSpecimenImage(SpecimenSearchCriteria searchCriteria) {
        String requestParams = FluentSpecimenImageSearchApiBuilder.aRequest()
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("specimen_image", 10, searchCriteria.getPage(), new SortField(), requestParams);
    }

    @Override
    public Map findRawSpecimenImageById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity("specimen_image", requestParams);
    }


    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("specimen_identification")
                .relatedData("specimen_image")
                .relatedData("specimen_reference")
                .buildWithDefaultReturningFields();
        return apiService.findRawEntity(SPECIMEN_TABLE, requestParams);
    }

    @Override
    public ApiResponse findSpecimensForIndex(SpecimenSearchCriteria searchCriteria) {
        String requestParams = FluentSpecimenSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .querySpecimenNumber(searchCriteria.getSpecimenNumber()).andReturn()
                .queryNameOfFossil(searchCriteria.getFossilName()).andReturn()
                .queryClassification(searchCriteria.getClassification()).andReturn()
                .buildFullQuery();
        return apiService.searchRawEntities(
                SPECIMEN_TABLE, indexingProperties.getIndexingBatchSize(), searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findSpecimensByIds(Collection<String> ids) {
        String requestParams = FluentSpecimenSearchApiBuilder.aRequest()
                .queryMultipleIds(ids).andReturn()
                .querySpecimenNumber(null).andReturn()
                .queryNameOfFossil(null).andReturn()
                .queryClassification(null).andReturn()
                .returnDateChanged()
                .buildFullQuery();
        //This + 1 in paginateBy is very important! (API does not accept neither 0, nor 1 values there)
        return apiService.searchRawEntities(SPECIMEN_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }
}
