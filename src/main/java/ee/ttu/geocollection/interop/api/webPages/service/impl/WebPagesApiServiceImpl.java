package ee.ttu.geocollection.interop.api.webPages.service.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.webPages.service.WebPagesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebPagesApiServiceImpl implements WebPagesApiService {

    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse getWebPages(int id)  {
        SortField sortField = new SortField();
        sortField.setOrder(SortingOrder.ASCENDING);
        String params = "&id=" + id;
        return apiService.searchRawEntities("webpages", 1, sortField, params);
    }
}
