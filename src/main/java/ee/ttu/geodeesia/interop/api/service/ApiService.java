package ee.ttu.geodeesia.interop.api.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.common.GeoEntity;
import ee.ttu.geodeesia.search.domain.SortField;

import java.util.List;

public interface ApiService {
    //search without returning exactly fields
    <T> Response<T> searchEntities(String tableName, int page, SortField sortField, String requestParams, Class<T> responseClass);

    <T> Response<T> findEntity(String tableName, String requestParams, Class<T> responseClass);
    List<?> findByParam(String tableName, String requestParams);

    <T extends GeoEntity> T findEntityAndMagicallyDeserialize(String tableName, String requestParams, Class<T> responseClass);

    <T> Response<T> searchEntitiesAngMagicallyDeserialize(String tableName, int page, SortField sortField, String requestParams, Class<T> responseClass);
}
