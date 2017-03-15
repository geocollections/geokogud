package ee.ttu.geodeesia.search.controller;


import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geodeesia.interop.api.samples.service.SamplesApiService;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import ee.ttu.geodeesia.search.domain.LookUpType;
import ee.ttu.geodeesia.search.domain.SearchField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    private SoilApiService soilApiService;
    @Autowired
    private SamplesApiService samplesApiService;

    @RequestMapping(value = "/soil/{id}")
    public SoilDetailsDialogDto findSoilById(@PathVariable Long id) {
        SampleSearchCriteria criteria = new SampleSearchCriteria();
        criteria.setSoilSiteId(new SearchField(id.toString(), LookUpType.exact));

        Response soil = soilApiService.findById(id);
        Response samples = samplesApiService.searchSamples(criteria);

        return new SoilDetailsDialogDto(soil, samples);
    }

}
