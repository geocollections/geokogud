package ee.ttu.geocollection.endpoint.web;

import ee.ttu.geocollection.interop.api.localities.pojo.LocalityMapFilter;
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

    @RequestMapping(value = "/locality-summary")
    @ResponseBody
    public Map findLocalitySummary() {
        return localitiesApiService.findLocalitiesSummary();
    }
    @RequestMapping(value = "/locality-summary-filter")
    @ResponseBody
    public Map findLocalitySummaryFilter(@RequestBody LocalityMapFilter filters) {
        return localitiesApiService.findLocalitiesSummaryFilter(filters);
    }
}
