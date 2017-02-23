package ee.ttu.geodeesia.search.controller;

import ee.ttu.geodeesia.interop.api.Request.AbstractSearch;
import ee.ttu.geodeesia.interop.api.Request.SampleSearch;
import ee.ttu.geodeesia.interop.api.Request.SearchFactory;
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
        return SearchFactory.create(search);
    }

    @RequestMapping(value = "/sample-list", method= RequestMethod.POST)
    @ResponseBody
    public SampleApiResponse sampleRequest(@RequestBody final SampleSearch search){
        return null;
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
