package ee.ttu.geocollection.interop.api.localities.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityMapFilter;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalitySearchCriteria;

import java.util.Map;

public interface LocalitiesApiService {

    ApiResponse findLocality(LocalitySearchCriteria searchCriteria) ;

    ApiResponse findLocalityImage(LocalitySearchCriteria searchCriteria) ;

    Map findRawById(Long id);

    Map findLocalitiesSummary();

    Map findLocalitiesSummaryFilter(LocalityMapFilter filters);
}
