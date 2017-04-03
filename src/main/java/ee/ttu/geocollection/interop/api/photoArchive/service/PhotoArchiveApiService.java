package ee.ttu.geocollection.interop.api.photoArchive.service;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;

public interface PhotoArchiveApiService {
    Response findPhoto(PhotoArchiveSearchCriteria searchCriteria);

    Response findById(Long id);
}