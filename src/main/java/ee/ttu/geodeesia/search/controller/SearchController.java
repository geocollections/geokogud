package ee.ttu.geodeesia.search.controller;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleSearch;
import ee.ttu.geodeesia.interop.api.samples.service.SamplesApiService;
import ee.ttu.geodeesia.interop.api.taxon.pojo.TaxonApiResponse;
import ee.ttu.geodeesia.interop.api.taxon.service.TaxonApiService;
import ee.ttu.geodeesia.search.domain.AbstractSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private TaxonApiService taxonApiService;

    @RequestMapping(value = "/get-search", method = RequestMethod.GET)
    public AbstractSearch getSearch(@RequestParam("name") String search) {
        return new SampleSearch(search);
    }

    @RequestMapping(value = "/sample-list", method = RequestMethod.POST)
    public Response sampleRequest(SampleSearch search) {
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
}
