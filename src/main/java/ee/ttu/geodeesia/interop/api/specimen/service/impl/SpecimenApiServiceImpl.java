package ee.ttu.geodeesia.interop.api.specimen.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ttu.geodeesia.interop.api.Response.ApiResponse;
import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.Response.ResponseMapper;
import ee.ttu.geodeesia.interop.api.builder.FluentGeoApiBuilder;
import ee.ttu.geodeesia.interop.api.service.ApiService;
import ee.ttu.geodeesia.interop.api.soil.pojo.SoilApiResponse;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenEntity;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenSearchCriteria;
import ee.ttu.geodeesia.interop.api.specimen.service.SpecimenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SpecimenApiServiceImpl implements SpecimenApiService {
    @Autowired
    private ApiService apiService;

    @Override
    public Response findSpecimen(SpecimenSearchCriteria searchCriteria) {
        String requestParams = FluentGeoApiBuilder.aRequest()
                .queryId(searchCriteria.getId()).andReturn()
                .querySpecimenNumber(searchCriteria.getSpecimenNumber()).andReturn()
                .queryClassification(searchCriteria.getClassification()).andReturn()
                .queryMineralRock(searchCriteria.getMineralRock()).andReturn()
                .queryLocality(searchCriteria.getLocality()).andReturn()
                .queryDepth(searchCriteria.getDepth()).andReturn()
                .queryStratigraphy(searchCriteria.getStratigraphy()).andReturn()
                .build();
        return apiService.findEntity("specimen", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams, SpecimenEntity.class);
    }
}
