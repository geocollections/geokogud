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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class SpecimenApiServiceImpl implements SpecimenApiService {
    public static final String SPECIMEN_TABLE = "specimen";
    private List<String> fields = Arrays.asList(
            "id",
            "classification__class_field",
            "classification__class_en",
            "coll_id",
            "coll__name",
            "coll__number",
            "coll__remarks",
            "lithostratigraphy_id",
            "lithostratigraphy__stratigraphy",
            "lithostratigraphy__stratigraphy_en",
            "locality__asustusyksus__asustusyksus",
            "locality__asustusyksus__asustusyksus_en",
            "locality__country__value",
            "locality__country__value_en",
            "locality__depth",
            "locality__eelis",
            "locality__elevation",
            "locality_id",
            "locality__latitude",
            "locality__locality",
            "locality__locality_en",
            "locality__longitude",
            "locality__maaamet_pa_id",
            "locality__maakond__maakond",
            "locality__maakond__maakond_en",
            "locality__number",
            "locality__parent__locality",
            "locality__remarks_location",
            "locality__stratigraphy_base_id",
            "locality__stratigraphy_base__stratigraphy",
            "locality__stratigraphy_base__stratigraphy_en",
            "locality__stratigraphy_top_id",
            "locality__stratigraphy_top__stratigraphy",
            "locality__stratigraphy_top__stratigraphy_en",
            "locality__type__value",
            "locality__type__value_en",
            "locality__vald__vald",
            "locality__vald__vald_en",
            "depth",
            "depth_interval",
            "sample__agent_collected__agent",
            "sample__agent_collected_free",
            "sample__classification_rock__name",
            "sample__classification_rock__name_en",
            "sample__database__acronym",
            "sample__date_collected",
            "sample__date_collected_free",
            "sample__depth",
            "sample__depth_interval",
            "sample_id",
            "sample__lithostratigraphy_id",
            "sample__lithostratigraphy__stratigraphy",
            "sample__lithostratigraphy__stratigraphy_en",
            "sample__locality__asustusyksus__asustusyksus",
            "sample__locality__asustusyksus__asustusyksus_en",
            "sample__locality__country__value",
            "sample__locality__country__value_en",
            "sample__locality__depth",
            "sample__locality__eelis",
            "sample__locality__elevation",
            "sample__locality_free",
            "sample__locality_id",
            "sample__locality__latitude",
            "sample__locality__locality",
            "sample__locality__locality_en",
            "sample__locality__longitude",
            "sample__locality__maaamet_pa_id",
            "sample__locality__maakond__maakond",
            "sample__locality__maakond__maakond_en",
            "sample__locality__number",
            "sample__locality__parent__locality",
            "sample__locality__remarks_location",
            "sample__locality__stratigraphy_base_id",
            "sample__locality__stratigraphy_base__stratigraphy",
            "sample__locality__stratigraphy_base__stratigraphy_en",
            "sample__locality__stratigraphy_top_id",
            "sample__locality__stratigraphy_top__stratigraphy",
            "sample__locality__stratigraphy_top__stratigraphy_en",
            "sample__locality__type__value",
            "sample__locality__type__value_en",
            "sample__locality__vald__vald",
            "sample__locality__vald__vald_en",
            "sample__location",
            "sample__mass",
            "sample__number",
            "sample__number_additional",
            "sample__remarks",
            "sample__rock",
            "sample__rock_en",
            "sample__series_id",
            "sample__soil_site_id",
            "sample__soil_site__land_use",
            "sample__soil_site__latitude",
            "sample__soil_site__longitude",
            "sample__soil_site__site",
            "sample__soil_site__site_en",
            "sample__soil_site__soil",
            "sample__stratigraphy_bed",
            "sample__stratigraphy_id",
            "sample__stratigraphy__stratigraphy",
            "sample__stratigraphy__stratigraphy_en",
            "specimen_nr",
            "stratigraphy_id",
            "stratigraphy__stratigraphy",
            "stratigraphy__stratigraphy_en",
            "stratigraphy_free",
            "specimenidentification__name",
            "specimenidentification__taxon_id",
            "specimenidentification__taxon__taxon",
            //"specimenidentification__taxon__author_year",
            //"specimenidentification__taxon__parent__taxon",
            //"specimenidentification__taxon__fossil_group__taxon",
            "fossil__value",
            "fossil__value_en",
            "agent_collected_id",
            "agent_collected__agent",
            "agent_collected__forename",
            "agent_collected__surename",
            "specimenreference__reference__author",
            "specimenreference__reference__title",
            "original_status__value",
            "original_status__value_en",
            "part",
            "date_added",
            "specimen_id",
            "type__value_en",
            "kind__value_en"
    );

    @Autowired
    private ApiService apiService;
    @Autowired
    private IndexingProperties indexingProperties;

    @Override
    public ApiResponse findSpecimen(SpecimenSearchCriteria searchCriteria)  {
        String requestParams = prepareCommonFields(searchCriteria)
                .queryId(searchCriteria.getId()).andReturn()
                .buildFullQuery();
        return apiService.searchRawEntities(SPECIMEN_TABLE, searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    private FluentSpecimenSearchApiBuilder prepareCommonFields(SpecimenSearchCriteria searchCriteria) {
        return FluentSpecimenSearchApiBuilder.aRequest()
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
                .returnLongitude();
    }

    @Override
    public ApiResponse findSpecimenImage(SearchField specimenId) {
        String requestParams = FluentSpecimenImageSearchApiBuilder.aRequest()
                .querySpecimenIdForUrl(specimenId).andReturn()
                .returnImageUrl()
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
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
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
        String requestParams = prepareCommonFields(new SpecimenSearchCriteria())
                .queryMultipleIds(ids).andReturn()
                .buildFullQuery();
        //This + 1 in paginateBy is very important! (API does not accept neither 0, nor 1 values there)
        return apiService.searchRawEntities(SPECIMEN_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }
}
