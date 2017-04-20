package ee.ttu.geocollection.interop.api.specimen.service;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geocollection.domain.SearchField;

import java.util.Map;

public interface SpecimenApiService {
    ApiResponse findSpecimen(SpecimenSearchCriteria searchCriteria) throws AppException;

    ApiResponse findSpecimenImage(SearchField specimenId) throws AppException;

    Map findRawSpecimenImageById(Long id);
    Map findRawById(Long id);
}
