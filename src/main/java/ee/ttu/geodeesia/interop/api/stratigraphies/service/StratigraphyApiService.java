package ee.ttu.geodeesia.interop.api.stratigraphies.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import ee.ttu.geodeesia.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;

public interface StratigraphyApiService {
    Response<StratigraphyEnitity> findStratigraphy(StratigraphySearchCriteria searchCriteria);

    Response<StratigraphyEnitity> findById(Long id);
}
