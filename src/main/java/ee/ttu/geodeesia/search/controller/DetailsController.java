package ee.ttu.geodeesia.search.controller;


import ee.ttu.geodeesia.interop.api.Request.SampleSearchCriteria;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleDetailsDialogDto;
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
    private DrillCoreApiService drillCoreApiService;
    @Autowired
    private SoilApiService soilApiService;
    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private PhotoArchiveApiService photoArchiveApiService;
    @Autowired
    private LocalitiesApiService localitiesApiService;

    @RequestMapping(value = "/soil/{id}")
    public SoilDetailsDialogDto findSoilById(@PathVariable Long id) {
        SampleSearchCriteria criteria = new SampleSearchCriteria();
        criteria.setSoilSiteId(new SearchField(id.toString(), LookUpType.exact));

        Response soil = soilApiService.findById(id);
        Response samples = samplesApiService.searchSamples(criteria);

        return new SoilDetailsDialogDto(soil, samples);
    }

    @RequestMapping(value = "/drillcore/{id}")
    public DrillCoreDetailsDialogDto findDrillCoreById(@PathVariable Long id) {
        Response drillCore = drillCoreApiService.findById(id);
        return new DrillCoreDetailsDialogDto(drillCore);
    }

    @RequestMapping(value = "/sample/{id}")
    public SampleDetailsDialogDto findSampleById(@PathVariable Long id) {
        Response samples = samplesApiService.findById(id);
        return new SampleDetailsDialogDto(samples);
    }

    @RequestMapping(value = "/photo-archive/{id}")
    public PhotoArchiveDetailsDialogDto findPhotoArchiveById(@PathVariable Long id) {
        Response photo = photoArchiveApiService.findById(id);
        return new PhotoArchiveDetailsDialogDto(photo);
    }

    @RequestMapping(value = "/locality/{id}")
    public LocalityDetailsDialogDto findLocalityById(@PathVariable Long id) {
        Response locality = localitiesApiService.findById(id);
        return new LocalityDetailsDialogDto(locality,null,null);
    }
}