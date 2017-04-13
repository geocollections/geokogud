package ee.ttu.geocollection.interop.api.webNews.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.geocollection.interop.api.Response.Response;
import ee.ttu.geocollection.interop.api.builder.ApiFields;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.webNews.pojo.WebNewsEntity;
import ee.ttu.geocollection.interop.api.webNews.service.WebNewsApiService;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;

@Service
public class WebNewsApiServiceImpl implements WebNewsApiService {

    @Autowired
    private ApiService apiService;

    @Override
    public Response getNews() {
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        SortField sortField = new SortField();
        sortField.setOrder(SortingOrder.DESCENDING);
        String params = "&" + ApiFields.DATE_ADDED_LT + "=" + curYear + "-12-31";
        return apiService.searchEntities("webnews", 1, sortField, params, WebNewsEntity.class);
    }
}
