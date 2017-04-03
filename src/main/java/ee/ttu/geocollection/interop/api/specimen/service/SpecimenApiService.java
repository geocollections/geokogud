package ee.ttu.geocollection.interop.api.specimen.service;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenEntity;
import ee.ttu.geocollection.interop.api.specimen.pojo.SpecimenSearchCriteria;

public interface SpecimenApiService {
    Response<SpecimenEntity> findSpecimen(SpecimenSearchCriteria searchCriteria);
}
