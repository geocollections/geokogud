package ee.ttu.geodeesia.interop.api.photoArchive.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;

public interface PhotoArchiveApiService {
    Response findPhoto(PhotoArchiveSearchCriteria searchCriteria);

    Response findById(Long id);
}