package ee.ttu.geodeesia.search.controller;


import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    private SoilApiService soilApiService;

    @RequestMapping(value = "/soil/{id}")
    public Response findSoilById(@PathVariable Long id) {
        return soilApiService.findById(id);
    }

}
