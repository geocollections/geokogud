package ee.ttu.geodeesia.interop.api.specimen.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenSearchCriteria;

public interface SpecimenApiService {
    Response findSpecimen(SpecimenSearchCriteria searchCriteria);
}
