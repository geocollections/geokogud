package ee.ttu.geocollection.interop.api.service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.common.GeoEntity;
import ee.ttu.geocollection.search.domain.SortField;

import java.util.List;
import java.util.Map;

public interface ApiService {
    Map findRawEntity(String tableName, String requestParams);

    ApiResponse searchRawEntities(String tableName, int page, SortField sortField, String requestParams);



    Map findRawEntities(String tableName, String requestParams);

    List<?> findByParam(String tableName, String requestParams);

    //search without returning exactly fields
    <T> Response<T> searchEntities(String tableName, int page, SortField sortField, String requestParams, Class<T> responseClass);

    <T> Response<T> findEntity(String tableName, String requestParams, Class<T> responseClass);

    <T extends GeoEntity> T findEntityAndMagicallyDeserialize(String tableName, String requestParams, Class<T> responseClass);

    <T> Response<T> searchEntitiesAngMagicallyDeserialize(String tableName, int page, SortField sortField, String requestParams, Class<T> responseClass);
}
