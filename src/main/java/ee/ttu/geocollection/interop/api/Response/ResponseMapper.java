package ee.ttu.geocollection.interop.api.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import ee.ttu.geocollection.interop.api.analyses.pojo.AnalysesEntity;
import ee.ttu.geocollection.interop.api.localities.pojo.LocalityEntity;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ResponseMapper {
    private ImmutableMap<String, Class<? extends ConvertableToResponseEntity>> responseClasses =
            ImmutableMap.<String, Class<? extends ConvertableToResponseEntity>>builder()
                    .put("sample", SampleEntity.class)
                    .put("locality", LocalityEntity.class)
                    //.put("reference", ReferenceEntity.class)
                    .put("analysis", AnalysesEntity.class)
                    //.put("drillcore", DrillCoresEntity.class)
                    //.put("image", PhotoArchiveEntity.class)
                    .build();

    public List<?> toResponseEntities(String objectType, List<?> result) {
        ObjectMapper mapper = new ObjectMapper();
        Class<? extends ConvertableToResponseEntity> responseClass = responseClasses.get(objectType);
        return result.stream()
                .map(rawJson -> mapper.convertValue(rawJson, responseClass))
                .map(ConvertableToResponseEntity::toResponse)
                .collect(toList());
    }
}