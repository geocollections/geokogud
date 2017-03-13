package ee.ttu.geodeesia.search.controller;

import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.NewVersionOfApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiSearchCriteria;
import ee.ttu.geodeesia.interop.api.doi.service.DoiApiService;
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
    private DoiApiService doiApiService;
    @Autowired
    private SpecimenApiService specimenApiService;

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

    @RequestMapping(value = "/soil", method = RequestMethod.POST)
    public Response searchSoil(@RequestBody SoilSearchCriteria searchCriteria) {
        return soilApiService.findSoil(searchCriteria);
    }

    @RequestMapping(value = "/doi", method = RequestMethod.POST)
    public Response searchDoi(@RequestBody DoiSearchCriteria searchCriteria) {
        System.err.println("searching");
        return doiApiService.findDoi(searchCriteria);
    }

    @RequestMapping(value = "/specimen", method = RequestMethod.POST)
    public Response searchSpecimen(@RequestBody SpecimenSearchCriteria specimenSearchCriteria) {
        return specimenApiService.findSpecimen(specimenSearchCriteria);
    }
}
