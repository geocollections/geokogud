package ee.ttu.geodeesia.search.controller;

import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.NewVersionOfApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;
import ee.ttu.geodeesia.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geodeesia.interop.api.preparations.PreparationsApiService;
import ee.ttu.geodeesia.interop.api.preparations.pojo.PreparationsSearchCriteria;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceSearchCriteria;
import ee.ttu.geodeesia.interop.api.reference.service.ReferenceApiService;
import ee.ttu.geodeesia.interop.api.samples.service.SamplesApiService;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geodeesia.interop.api.specimen.service.SpecimenApiService;
import ee.ttu.geodeesia.interop.api.taxon.pojo.TaxonApiResponse;
import ee.ttu.geodeesia.interop.api.taxon.service.TaxonApiService;
import ee.ttu.geodeesia.search.domain.CommonSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private ReferenceApiService referenceApiService;
    @Autowired
    private PhotoArchiveApiService photoArchiveApiService;
    @Autowired
    private PreparationsApiService preparationsApiService;

    @RequestMapping(value = "/get-search", method = RequestMethod.GET)
    public CommonSearch getSearch(@RequestParam("name") String search) {
        return new CommonSearch(search);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Response sampleRequest(@RequestBody CommonSearch search) {
        return samplesApiService.searchList(search);
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

    @RequestMapping(value = "/{table}", method = RequestMethod.GET)
    public ApiResponse search(@PathVariable String table,@RequestParam("term") String q) {
        return taxonApiService.searchLocality(q, table);
    }

    @RequestMapping(value = "/specimen", method = RequestMethod.POST)
    public Response searchSpecimen(@RequestBody SpecimenSearchCriteria specimenSearchCriteria) {
        return specimenApiService.findSpecimen(specimenSearchCriteria);
    }

    @RequestMapping(value = "/photo-archive", method = RequestMethod.POST)
    public Response searchSpecimen(@RequestBody PhotoArchiveSearchCriteria photoArchiveSearchCriteria) {
        return photoArchiveApiService.findPhoto(photoArchiveSearchCriteria);
    }

    @RequestMapping(value = "/soil", method = RequestMethod.POST)
    public Response searchSoil(@RequestBody SoilSearchCriteria searchCriteria) {
        return soilApiService.findSoil(searchCriteria);
    }

    @RequestMapping(value = "/doi", method = RequestMethod.POST)
    public Response searchDoi(@RequestBody ReferenceSearchCriteria searchCriteria) {
        return referenceApiService.findDoi(searchCriteria);
    }

    @RequestMapping(value = "/reference", method = RequestMethod.POST)
    public Response searchReference(@RequestBody ReferenceSearchCriteria searchCriteria) {
        return referenceApiService.findReference(searchCriteria);
    }

    @RequestMapping(value = "/preparations", method = RequestMethod.POST)
    public Response searchPreparations(@RequestBody PreparationsSearchCriteria preparationsSearchCriteria) {
        return preparationsApiService.findPreparations(preparationsSearchCriteria);
    }
}