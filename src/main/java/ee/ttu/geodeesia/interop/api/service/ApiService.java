package ee.ttu.geodeesia.interop.api.service;

import ee.ttu.geodeesia.interop.api.Response.Response;

public interface ApiService {
    Response findEntity(String tableName, int page, String requestParams, Class<?> responseClass);
}
