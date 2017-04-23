package ee.ttu.geocollection.interop.api.photoArchive.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.photoArchive.pojo.PhotoArchiveSearchCriteria;

import java.util.Map;

public interface PhotoArchiveApiService {
    ApiResponse findPhoto(PhotoArchiveSearchCriteria searchCriteria) ;

    Map findRawById(Long id);
}