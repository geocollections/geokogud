package ee.ttu.geocollection.interop.api.localities.service;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityMapFilter;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;

import java.util.ArrayList;
import java.util.Map;

public interface LocalitiesApiService {

    ApiResponse findLocality(LocalitySearchCriteria searchCriteria) throws AppException;

    ApiResponse findLocalityImage(SearchField specimenId) throws AppException;

    Map findRawById(Long id);

    Map findLocalitiesSummary();

    Map findLocalitiesSummaryFilter(LocalityMapFilter filters);
}
