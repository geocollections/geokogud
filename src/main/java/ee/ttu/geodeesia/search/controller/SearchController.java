package ee.ttu.geodeesia.search.controller;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.samples.service.SamplesApiService;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilSearchCriteria;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
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

    @RequestMapping(value = "/get-search", method = RequestMethod.GET)
    public CommonSearch getSearch(@RequestParam("name") String search) {
        return new CommonSearch(search);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Response sampleRequest(@RequestBody CommonSearch search) {
        return samplesApiService.searchSampleList(search);
    }

    @RequestMapping(value = "/taxon-list", method = RequestMethod.GET)
    public TaxonApiResponse list() {
        return taxonApiService.searchTaxonList();
    }

    @RequestMapping(value = "/taxon", method = RequestMethod.GET)
    public TaxonApiResponse list(@RequestParam("term") String q) {
        return taxonApiService.searchTaxon(q);
    }

    @RequestMapping(value = "/searchSoil")
    public SoilApiResponse searchSoil(@RequestBody SoilSearchCriteria searchCriteria) {
        return soilApiService.findSoil(searchCriteria);
    }
}
