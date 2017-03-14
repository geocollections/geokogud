package ee.ttu.geodeesia.interop.api.preparations;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.preparations.pojo.PreparationsSearchCriteria;

public interface PreparationsApiService {
    Response findPreparations(PreparationsSearchCriteria preparationsSearchCriteria);
}
