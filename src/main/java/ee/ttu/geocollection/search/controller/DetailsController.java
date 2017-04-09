package ee.ttu.geocollection.search.controller;


import ee.ttu.geocollection.interop.api.Request.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.analyses.search.AnalysesApiService;
import ee.ttu.geocollection.interop.api.doi.service.DoiApiService;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillCoreProto;
import ee.ttu.geocollection.interop.api.drillCores.pojo.DrillcoreBox;
import ee.ttu.geocollection.interop.api.drillCores.service.DrillCoreApiService;
import ee.ttu.geocollection.interop.api.localities.pojo.Locality;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityDetailsDialogDto;
import ee.ttu.geocollection.interop.api.localities.service.LocalitiesApiService;
import ee.ttu.geocollection.interop.api.photoArchive.pojo.PhotoArchiveDetailsDialogDto;
import ee.ttu.geocollection.interop.api.photoArchive.service.PhotoArchiveApiService;
import ee.ttu.geocollection.interop.api.preparations.PreparationsApiService;
import ee.ttu.geocollection.interop.api.reference.pojo.ReferenceDetailsDialogDto;
import ee.ttu.geocollection.interop.api.reference.service.ReferenceApiService;
import ee.ttu.geocollection.interop.api.samples.pojo.Sample;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleDetailsDialogDto;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import ee.ttu.geocollection.interop.api.soil.pojo.Soil;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilDetailsDialogDto;
import ee.ttu.geocollection.interop.api.soil.pojo.SoilHorizon;
import ee.ttu.geocollection.interop.api.soil.service.SoilApiService;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geocollection.interop.api.specimen.service.SpecimenApiService;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphyDetailsDialogDto;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import ee.ttu.geocollection.interop.api.stratigraphies.service.StratigraphyApiService;
import ee.ttu.geocollection.search.domain.LookUpType;
import ee.ttu.geocollection.search.domain.SearchField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private StratigraphyApiService stratigraphyApiService;
    @Autowired
    private AnalysesApiService analysesApiService;
    @Autowired
    private PreparationsApiService preparationsApiService;

    @RequestMapping(value = "/field", method = RequestMethod.GET)
    public List<?> findDoiById(
            @RequestParam("table") String table,
            @RequestParam("term") String term,
            @RequestParam("searchField") String searchField) {
        return doiApiService.searchByField(table, term, searchField);
    }

    @RequestMapping(value = "/soil/{id}")
    public SoilDetailsDialogDto findSoilById(@PathVariable Long id) {
        SampleSearchCriteria criteria = new SampleSearchCriteria();
        criteria.setSoilSiteId(new SearchField(id.toString(), LookUpType.exact));

        Soil soil = soilApiService.findById(id);
        Response<Sample> samples = samplesApiService.searchSamples(criteria);
        Response<SoilHorizon> soilHorizons = soilApiService.findSoilHorizons(null);

        return new SoilDetailsDialogDto(soil, samples);
    }

    @RequestMapping(value = "/drillcore/{id}")
    public DrillCoreProto findDrillCoreById(@PathVariable Long id) {
        return drillCoreApiService.findDrillcoreById(id);
    }

    @RequestMapping(value = "/drillcoreBox/{id}")
    public DrillcoreBox findDrillcoreBoxById(@PathVariable Long id) {
        return drillCoreApiService.findDrillcoreBoxById(id);
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
    @RequestMapping(value = "/raw-specimen/{id}")
    public Map findRawSpecimenById(@PathVariable Long id) {
        return specimenApiService.findRawById(id);
    }

    @RequestMapping(value = "/raw-sample/{id}")
    public Map findRawSampleById(@PathVariable Long id) {
        return samplesApiService.findRawById(id);
    }

    @RequestMapping(value = "/raw-drillcore/{id}")
    public Map findRawDrillCoreById(@PathVariable Long id) {
        return drillCoreApiService.findRawById(id);
    }

    @RequestMapping(value = "/raw-locality/{id}")
    public Map findRawLocalityById(@PathVariable Long id) {
        return localitiesApiService.findRawById(id);
    }

    @RequestMapping(value = "/raw-stratigraphy/{id}")
    public Map findRawStratigraphyById(@PathVariable Long id) {
        return stratigraphyApiService.findRawById(id);
    }


    @RequestMapping(value = "/raw-reference/{id}")
    public Map findRawReferenceById(@PathVariable Long id) {
        return referenceApiService.findRawById(id);
    }

    @RequestMapping(value = "/raw-analysis/{id}")
    public Map findRawAnalysisById(@PathVariable Long id) {
        return analysesApiService.findRawById(id);
    }
    @RequestMapping(value = "/raw-preparation/{id}")
    public Map findRawPreparationById(@PathVariable Long id) {
        return preparationsApiService.findRawById(id);
    }
    @RequestMapping(value = "/raw-photo-archive/{id}")
    public Map findRawPhotoArchiveById(@PathVariable Long id) {
        return photoArchiveApiService.findRawById(id);
    }
    @RequestMapping(value = "/raw-soil/{id}")
    public Map findRawSoilById(@PathVariable Long id) {
        return soilApiService.findRawById(id);
    }
    @RequestMapping(value = "/raw-doi/{id}")
    public Map findRawDoiById(@PathVariable Long id) {
        return doiApiService.findRawById(id);
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
        specimenSearchCriteria.setLocality(new SearchField(locality.getResult().get(0).getLocality(), LookUpType.exact));
        ApiResponse specimens = specimenApiService.findSpecimen(specimenSearchCriteria);
        return new LocalityDetailsDialogDto(locality, null, specimens);
    }

    @RequestMapping(value = "/stratigraphy/{id}")
    public StratigraphyDetailsDialogDto findStratigraphyById(@PathVariable Long id) {
        Response<StratigraphyEnitity> straigraphy = stratigraphyApiService.findById(id);
        return new StratigraphyDetailsDialogDto(straigraphy);
    }

}