package ee.ttu.geodeesia.search.controller;


import ee.ttu.geodeesia.interop.api.Request.SampleSearchCriteria;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.doi.service.DoiApiService;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoreDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geodeesia.interop.api.localities.pojo.Locality;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.reference.service.ReferenceApiService;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.samples.service.SamplesApiService;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilDetailsDialogDto;
import ee.ttu.geodeesia.interop.api.soil.service.SoilApiService;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geodeesia.interop.api.specimen.service.SpecimenApiService;
import ee.ttu.geodeesia.search.domain.LookUpType;
import ee.ttu.geodeesia.search.domain.SearchField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    private DrillCoreApiService drillCoreApiService;
    @Autowired
    private ReferenceApiService referenceApiService;
    @Autowired
    private DoiApiService doiApiService;
    @Autowired
    private SoilApiService soilApiService;
    @Autowired
    private SamplesApiService samplesApiService;
    @Autowired
    private PhotoArchiveApiService photoArchiveApiService;
    @Autowired
    private LocalitiesApiService localitiesApiService;
    @Autowired
    private SpecimenApiService specimenApiService;

    @RequestMapping(value = "/field", method = RequestMethod.GET)
    public List<?> findDoiById(
            @RequestParam("table") String table,
            @RequestParam("term") String term,
            @RequestParam("searchField") String searchField) {
        return doiApiService.searchByField(table,term,searchField);
    }

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


    @RequestMapping(value = "/reference/{id}")
    public ReferenceDetailsDialogDto findReferenceById(@PathVariable Long id) {
        return new ReferenceDetailsDialogDto(referenceApiService.findById(id));
    }

    @RequestMapping(value = "/doi/{id}")
    public ReferenceDetailsDialogDto findDoiById(@PathVariable Long id) {
        return new ReferenceDetailsDialogDto(doiApiService.findById(id));
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
        Response<Locality> locality = localitiesApiService.findById(id);
        SpecimenSearchCriteria specimenSearchCriteria = new SpecimenSearchCriteria();
        specimenSearchCriteria.setLocality(new SearchField(locality.getResult().get(0).getLocality(),LookUpType.exact));
        Response specimens = specimenApiService.findSpecimen(specimenSearchCriteria);
        return new LocalityDetailsDialogDto(locality,null, specimens);
    }
}