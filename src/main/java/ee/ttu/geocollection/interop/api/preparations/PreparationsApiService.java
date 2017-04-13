package ee.ttu.geocollection.interop.api.preparations;

import ee.ttu.geocollection.domain.AppException;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.preparations.pojo.PreparationsSearchCriteria;

import java.util.Map;

public interface PreparationsApiService {
    ApiResponse findPreparations(PreparationsSearchCriteria searchCriteria) throws AppException;

    Map findRawById(Long id);
}
