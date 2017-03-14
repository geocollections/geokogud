package ee.ttu.geodeesia.interop.api.preparations.impl;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.preparations.PreparationsApiService;
import ee.ttu.geodeesia.interop.api.preparations.pojo.PreparationsSearchCriteria;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreparationsApiServiceImpl implements PreparationsApiService{

    @Autowired
    private ApiService apiService;

    @Override
    public Response findPreparations(PreparationsSearchCriteria preparationsSearchCriteria) {
        return null;
    }
}