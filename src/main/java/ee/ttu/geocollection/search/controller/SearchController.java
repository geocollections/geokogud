package ee.ttu.geocollection.search.controller;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.NewVersionOfApiResponse;
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
import ee.ttu.geocollection.interop.api.taxon.pojo.TaxonApiResponse;
import ee.ttu.geocollection.interop.api.taxon.service.TaxonApiService;
import ee.ttu.geocollection.search.domain.LookUpType;
import ee.ttu.geocollection.search.domain.SearchField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private TaxonApiService taxonApiService;
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

    @RequestMapping(value = "/autocomplete-field", method = RequestMethod.GET)
    public Map findDoiById(
            @RequestParam("table") String table,
            @RequestParam("term") String term,
            @RequestParam("searchField") String searchField) {
        return apiService.searchByField(table, term, searchField);
    }

    @RequestMapping(value = "/{entity}/{id}", method= RequestMethod.GET)
    @ResponseBody
    public NewVersionOfApiResponse getEntity(@PathVariable String entity, @PathVariable Long id){
        return samplesApiService.getEntityInfo(entity, id);
    }

    @RequestMapping(value = "/taxon", method = RequestMethod.GET)
    public TaxonApiResponse list(@RequestParam("term") String q) {
        return taxonApiService.searchTaxon(q);
    }

    @RequestMapping(value = "/specimen", method = RequestMethod.POST)
    public ApiResponse searchSpecimen(@RequestBody SpecimenSearchCriteria specimenSearchCriteria) {
        ApiResponse specimens = specimenApiService.findSpecimen(specimenSearchCriteria);
        for(Map map : specimens.getResult()){
            Map<String, Object> castedMap = (Map<String, Object>) map;
            map.put("specimen_image_thumbnail", specimenApiService.findSpecimenImage(new SearchField(castedMap.get("id").toString(), LookUpType.exact)));
        }
        return specimens;
    }

    @RequestMapping(value = "/sample", method = RequestMethod.POST)
    public ApiResponse searchSample(@RequestBody SampleSearchCriteria sampleSearchCriteria) {
        return samplesApiService.findSample(sampleSearchCriteria);
    }

    @RequestMapping(value = "/drillcore", method = RequestMethod.POST)
    public ApiResponse searchDrillCores(@RequestBody DrillCoreSearchCriteria searchCriteria) {
        return drillCoreApiService.findDrillCore(searchCriteria);
    }

    @RequestMapping(value = "/locality", method = RequestMethod.POST)
    public ApiResponse searchLocalities(@RequestBody LocalitySearchCriteria searchCriteria) {
        return localitiesApiService.findLocality(searchCriteria);
    }

    @RequestMapping(value = "/photo-archive", method = RequestMethod.POST)
    public ApiResponse searchPhotoArchive(@RequestBody PhotoArchiveSearchCriteria photoArchiveSearchCriteria) {
        return photoArchiveApiService.findPhoto(photoArchiveSearchCriteria);
    }

    @RequestMapping(value = "/soil", method = RequestMethod.POST)
    public ApiResponse searchSoil(@RequestBody SoilSearchCriteria searchCriteria) {
        return soilApiService.findSoil(searchCriteria);
    }

    @RequestMapping(value = "/reference", method = RequestMethod.POST)
    public ApiResponse searchDoi(@RequestBody ReferenceSearchCriteria searchCriteria) {
        return referenceApiService.findReference(searchCriteria);
    }

    @RequestMapping(value = "/doi", method = RequestMethod.POST)
    public ApiResponse searchReference(@RequestBody DoiSearchCriteria searchCriteria) {
        return doiApiService.findDoi(searchCriteria);
    }

    @RequestMapping(value = "/analyses", method = RequestMethod.POST)
    public ApiResponse searchAnalyses(@RequestBody AnalysesSearchCriteria analysesSearchCriteria) {
        return analysesApiService.findAnalyses(analysesSearchCriteria);
    }

    @RequestMapping(value = "/preparation", method = RequestMethod.POST)
    public ApiResponse searchPreparations(@RequestBody PreparationsSearchCriteria preparationsSearchCriteria) {
        return preparationsApiService.findPreparations(preparationsSearchCriteria);
    }

    @RequestMapping(value = "/stratigraphy", method = RequestMethod.POST)
    public ApiResponse searchStratigraphy(@RequestBody StratigraphySearchCriteria stratigraphySearchCriteria) {
        return stratigraphyApiService.findStratigraphy(stratigraphySearchCriteria);
    }
}