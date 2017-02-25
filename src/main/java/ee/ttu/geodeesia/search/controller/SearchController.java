package ee.ttu.geodeesia.search.controller;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.search.domain.AbstractSearch;
import ee.ttu.geodeesia.search.domain.SampleSearch;
import ee.ttu.geodeesia.search.domain.SearchFactory;
import ee.ttu.geodeesia.interop.api.Response.SampleApiResponse;
import ee.ttu.geodeesia.interop.api.Response.TaxonApiResponse;
import ee.ttu.geodeesia.interop.api.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 48707222248 on 18.02.2017.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private ApiService apiService;

    @RequestMapping(value = "/get-search", method= RequestMethod.GET)
    @ResponseBody
    public AbstractSearch getSearch(@RequestParam("name") String search){
        return new SampleSearch(search);
    }

    @RequestMapping(value = "/sample-list", method= RequestMethod.POST)
    @ResponseBody
    public Response sampleRequest(@RequestBody final SampleSearch search){
        return apiService.searchSampleList(search);
    }

    @RequestMapping(value = "/taxon-list", method= RequestMethod.GET)
    @ResponseBody
    public TaxonApiResponse list(){
        return apiService.searchTaxonList();
    }

    @RequestMapping(value = "/taxon", method= RequestMethod.GET)
    @ResponseBody
    public TaxonApiResponse list(@RequestParam("term") String q){
        return apiService.searchTaxon(q);
    }
}
