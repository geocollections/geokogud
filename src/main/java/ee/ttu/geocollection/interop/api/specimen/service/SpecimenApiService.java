package ee.ttu.geocollection.interop.api.specimen.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geocollection.search.domain.SearchField;

import java.util.Map;

public interface SpecimenApiService {
    ApiResponse findSpecimen(SpecimenSearchCriteria searchCriteria);

    ApiResponse findSpecimenImage(SearchField specimenId);


    Map findRawById(Long id);
}
