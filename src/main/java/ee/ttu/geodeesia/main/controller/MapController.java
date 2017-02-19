package ee.ttu.geodeesia.main.controller;

import ee.ttu.geodeesia.interop.api.Response.LocalityApiResponse;
import ee.ttu.geodeesia.interop.api.Response.TaxonApiResponse;
import ee.ttu.geodeesia.interop.api.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 48707222248 on 19.02.2017.
 */
@Controller
@RequestMapping("/locality")
public class MapController {

    private static final Logger logger = LoggerFactory.getLogger(MapController.class);

    @Autowired
    private ApiService apiService;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    @ResponseBody
    public LocalityApiResponse getLocality(@PathVariable Long id){
        return apiService.getLocality(id);
    }
}

