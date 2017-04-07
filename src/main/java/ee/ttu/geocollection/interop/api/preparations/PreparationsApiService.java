package ee.ttu.geocollection.interop.api.preparations;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.preparations.pojo.PreparationsSearchCriteria;

public interface PreparationsApiService {
    ApiResponse findPreparations(PreparationsSearchCriteria searchCriteria);
}
