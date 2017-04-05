package ee.ttu.geocollection.main.controller;

import ee.ttu.geocollection.interop.api.localities.pojo.LocalityApiResponse;
import ee.ttu.geocollection.interop.api.localities.service.LocalitiesApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/map")
public class MapController {

    private static final Logger logger = LoggerFactory.getLogger(MapController.class);

    @Autowired
    private LocalitiesApiService localitiesApiService;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    @ResponseBody
    public LocalityApiResponse getLocality(@PathVariable Long id){
        return localitiesApiService.getLocality(id);
    }

    @RequestMapping(value = "/locality-summary")
    public Map findLocalitySummary() {
        return localitiesApiService.findLocalitiesSummary();
    }
}

