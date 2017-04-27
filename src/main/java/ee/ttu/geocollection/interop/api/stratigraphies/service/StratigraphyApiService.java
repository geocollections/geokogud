package ee.ttu.geocollection.interop.api.stratigraphies.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;

import java.util.List;
import java.util.Map;

public interface StratigraphyApiService {
    ApiResponse findStratigraphy(StratigraphySearchCriteria searchCriteria) ;

    Map findRawById(Long id);

    ApiResponse findStratigraphyForIndex(StratigraphySearchCriteria searchCriteria);

    ApiResponse findStratigraphyByIds(List<String> ids);
}
