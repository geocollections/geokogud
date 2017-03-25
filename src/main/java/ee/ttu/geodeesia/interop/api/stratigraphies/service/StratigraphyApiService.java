package ee.ttu.geodeesia.interop.api.stratigraphies.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.stratigraphies.pojo.StratigraphySearchCriteria;

public interface StratigraphyApiService {
    Response findStratigraphy(StratigraphySearchCriteria searchCriteria);

    Response findById(Long id);
}
