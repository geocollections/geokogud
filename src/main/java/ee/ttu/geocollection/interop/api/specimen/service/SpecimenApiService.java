package ee.ttu.geocollection.interop.api.specimen.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;

public interface SpecimenApiService {
    ApiResponse findSpecimen(SpecimenSearchCriteria searchCriteria);
}
