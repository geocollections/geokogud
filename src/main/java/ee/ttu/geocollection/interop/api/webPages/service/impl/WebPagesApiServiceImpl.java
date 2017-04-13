package ee.ttu.geocollection.interop.api.webPages.service.impl;

import ee.ttu.geocollection.domain.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.webPages.service.WebPagesApiService;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;

@Service
public class WebPagesApiServiceImpl implements WebPagesApiService {

    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse getWebPages(int id) throws AppException {
        SortField sortField = new SortField();
        sortField.setOrder(SortingOrder.ASCENDING);
        String params = "&id=" + id;
        return apiService.searchRawEntities("webpages", 1, sortField, params);
    }
}
