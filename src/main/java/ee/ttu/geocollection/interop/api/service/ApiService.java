package ee.ttu.geocollection.interop.api.service;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.common.GeoEntity;
import ee.ttu.geocollection.search.domain.SortField;

import java.util.List;
import java.util.Map;

public interface ApiService {
    //search without returning exactly fields
    <T> Response<T> searchEntities(String tableName, int page, SortField sortField, String requestParams, Class<T> responseClass);

    <T> Response<T> findEntity(String tableName, String requestParams, Class<T> responseClass);

    Map findRawEntity(String tableName, String requestParams);

    Map findRawEntities(String tableName, String requestParams);

    List<?> findByParam(String tableName, String requestParams);

    <T extends GeoEntity> T findEntityAndMagicallyDeserialize(String tableName, String requestParams, Class<T> responseClass);

    <T> Response<T> searchEntitiesAngMagicallyDeserialize(String tableName, int page, SortField sortField, String requestParams, Class<T> responseClass);
}
