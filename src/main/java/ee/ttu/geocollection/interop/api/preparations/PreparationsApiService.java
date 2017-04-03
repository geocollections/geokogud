package ee.ttu.geocollection.interop.api.preparations;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.preparations.pojo.PreparationsSearchCriteria;

public interface PreparationsApiService {
    Response findPreparations(PreparationsSearchCriteria preparationsSearchCriteria);
}
