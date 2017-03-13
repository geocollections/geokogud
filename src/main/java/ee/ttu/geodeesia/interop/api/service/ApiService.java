package ee.ttu.geodeesia.interop.api.service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.search.domain.SortField;

public interface ApiService {
    Response findEntity(String tableName, int page, SortField sortField, String requestParams, Class<?> responseClass);
}
