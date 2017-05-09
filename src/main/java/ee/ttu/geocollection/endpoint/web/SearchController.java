package ee.ttu.geocollection.endpoint.web;

import ee.ttu.geocollection.core.utils.ControllerHelper;
import ee.ttu.geocollection.domain.LookUpType;
import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.indexing.GlobalSearchService;
import ee.ttu.geocollection.interop.api.AsynchService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.analyses.pojo.AnalysesSearchCriteria;
import ee.ttu.geocollection.interop.api.analyses.search.AnalysesApiService;
import ee.ttu.geocollection.interop.api.doi.pojo.DoiSearchCriteria;
import ee.ttu.geocollection.interop.api.doi.service.DoiApiService;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreSearchCriteria;
import ee.ttu.geocollection.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;
import ee.ttu.geocollection.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geocollection.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;
import ee.ttu.geocollection.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geocollection.interop.api.preparations.PreparationsApiService;
import ee.ttu.geocollection.interop.api.preparations.pojo.PreparationsSearchCriteria;
import ee.ttu.geocollection.interop.api.reference.pojo.ReferenceSearchCriteria;
import ee.ttu.geocollection.interop.api.reference.service.ReferenceApiService;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geocollection.interop.api.soil.service.SoilApiService;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geocollection.interop.api.specimen.service.SpecimenApiService;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;
import ee.ttu.geocollection.interop.api.stratigraphies.service.StratigraphyApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController extends ControllerHelper {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private AsynchService asynchService;

    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private SoilApiService soilApiService;
    @Autowired
    private SpecimenApiService specimenApiService;
    @Autowired
    private DrillCoreApiService drillCoreApiService;
    @Autowired
    private ReferenceApiService referenceApiService;
    @Autowired
    private DoiApiService doiApiService;
    @Autowired
    private PhotoArchiveApiService photoArchiveApiService;
    @Autowired
    private PreparationsApiService preparationsApiService;
    @Autowired
    private LocalitiesApiService localitiesApiService;
    @Autowired
    private StratigraphyApiService stratigraphyApiService;
    @Autowired
    private AnalysesApiService analysesApiService;
    @Autowired
    private ApiService apiService;
    @Autowired
    private GlobalSearchService globalSearchService;

    @GetMapping(value = "/global/{query}")
    public Iterable searchGlobally(@PathVariable String query) {
        return globalSearchService.searchGlobally(query);
    }

    @GetMapping(value = "/autocomplete-field")
    public Map findDoiById(
            @RequestParam("table") String table,
            @RequestParam("term") String term,
            @RequestParam("searchField") String searchField) {
        return apiService.searchByField(table, term, searchField);
    }

    @PostMapping(value = "/specimen")
    public ApiResponse searchSpecimen(@RequestBody SpecimenSearchCriteria specimenSearchCriteria) {
        ApiResponse specimens = specimenApiService.findSpecimen(specimenSearchCriteria);
        if (specimens.getResult() != null) {
            asynchService.doAsynchCallsForEachResult(
                    specimens,
                    specimen ->
                            () -> specimenApiService.findSpecimenImage(
                                    new SearchField(specimen.get("specimen_id").toString(), LookUpType.exact)),
                    specimen ->
                            receivedImage -> specimen.put("specimen_image_thumbnail", receivedImage));

        }
 /*       if(specimenSearchCriteria.getSearchImages() != null
                && specimenSearchCriteria.getSearchImages().getName() != null
                && specimenSearchCriteria.getSearchImages().getName().equals("true")) {
            //specimens.getResult().stream().filter(sp -> xxx(sp));
            specimens = specimenApiService.findSpecimenImage(specimenSearchCriteria);
            if (specimens.getResult() != null) {
                asynchService.doAsynchCallsForEachResult(
                        specimens,
                        specimen ->
                                () -> iterateImages(specimen, specimenSearchCriteria),
                        specimen ->
                                receivedImage -> specimen.put("specimen_object", receivedImage));

            }
        } else {

        }*/

        return specimens;
    }
    private ApiResponse iterateImages(Map<String, Object> specimen, SpecimenSearchCriteria specimenSearchCriteria) {
        specimenSearchCriteria.setSpecimenNumber(new SearchField(
                specimen.get("specimen__specimen_id").toString(),
                LookUpType.exact));
        return specimenApiService.findSpecimen(specimenSearchCriteria);

    }

    @PostMapping(value = "/sample")
    public ApiResponse searchSample(@RequestBody SampleSearchCriteria sampleSearchCriteria) {
        return samplesApiService.findSample(sampleSearchCriteria);
    }

    @PostMapping(value = "/drillcore")
    public ApiResponse searchDrillCores(@RequestBody DrillCoreSearchCriteria searchCriteria) {
        ApiResponse drillCores =  drillCoreApiService.findDrillCore(searchCriteria);
        if (drillCores.getResult() != null) {
            asynchService.doAsynchCallsForEachResult(
                    drillCores,
                    drillCore ->
                            () -> drillCoreApiService.findDrillCoreImage(
                                    new SearchField(drillCore.get("id").toString(), LookUpType.exact)),
                    drillCore ->
                            receivedImage -> drillCore.put("drill_core_image_thumbnail", receivedImage));
        }
        return drillCores;
    }

    @PostMapping(value = "/locality")
    public ApiResponse searchLocalities(@RequestBody LocalitySearchCriteria searchCriteria) {

        ApiResponse localities =  localitiesApiService.findLocality(searchCriteria);
        if (localities.getResult() != null
                && searchCriteria.getSearchImages() != null
                && searchCriteria.getSearchImages().getName() != null
                && searchCriteria.getSearchImages().getName().equals("true")) {
            asynchService.doAsynchCallsForEachResult(
                    localities,
                    locality ->
                            () -> localitiesApiService.findLocalityImage(searchCriteria),
                    locality ->
                            receivedImage -> locality.put("locality_image_thumbnail", receivedImage));
        }
        return localities;
    }

    @PostMapping(value = "/photo-archive")
    public ApiResponse searchPhotoArchive(@RequestBody PhotoArchiveSearchCriteria photoArchiveSearchCriteria) {
        return photoArchiveApiService.findPhoto(photoArchiveSearchCriteria);
    }

    @PostMapping(value = "/soil")
    public ApiResponse searchSoil(@RequestBody SoilSearchCriteria searchCriteria) {
        return soilApiService.findSoil(searchCriteria);
    }

    @PostMapping(value = "/reference")
    public ApiResponse searchReferences(@RequestBody ReferenceSearchCriteria searchCriteria) {
        return referenceApiService.findReference(searchCriteria);
    }

    @PostMapping(value = "/doi")
    public ApiResponse searchDoi(@RequestBody DoiSearchCriteria searchCriteria) {
        return doiApiService.findDoi(searchCriteria);
    }

    @PostMapping(value = "/analyses")
    public ApiResponse searchAnalyses(@RequestBody AnalysesSearchCriteria analysesSearchCriteria) {
        return analysesApiService.findAnalyses(analysesSearchCriteria);
    }

    @PostMapping(value = "/preparation")
    public ApiResponse searchPreparations(@RequestBody PreparationsSearchCriteria preparationsSearchCriteria) {
        return preparationsApiService.findPreparations(preparationsSearchCriteria);
    }

    @PostMapping(value = "/stratigraphy")
    public ApiResponse searchStratigraphy(@RequestBody StratigraphySearchCriteria stratigraphySearchCriteria) {
        return stratigraphyApiService.findStratigraphy(stratigraphySearchCriteria);
    }
}