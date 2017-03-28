package ee.ttu.geodeesia.interop.api.webNews.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.builder.ApiFields;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import ee.ttu.geodeesia.interop.api.webNews.pojo.WebNewsEntity;
import ee.ttu.geodeesia.interop.api.webNews.service.WebNewsApiService;

@Service
public class WebNewsApiServiceImpl implements WebNewsApiService {

    @Autowired
    private ApiService apiService;

    @Override
    public Response getNews() {
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        String params = "&" + ApiFields.DATE_ADDED_LT + "=" + curYear + "-12-31";
        return apiService.searchEntities("webnews", 1, null, params, WebNewsEntity.class);
    }
}
