package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import ee.ttu.geodeesia.interop.api.analyses.pojo.AnalysesEntity;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityEntity;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceEntity;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleEntity;
import ee.ttu.geodeesia.interop.api.stratigraphies.pojo.StratigraphyEnitity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ResponseMapper {
    private ImmutableMap<String, Class<? extends ConvertableToResponseEntity>> responseClasses =
            ImmutableMap.<String, Class<? extends ConvertableToResponseEntity>>builder()
                    .put("sample", SampleEntity.class)
                    .put("locality", LocalityEntity.class)
                    .put("reference", ReferenceEntity.class)
                    .put("stratigraphy", StratigraphyEnitity.class)
                    .put("analysis", AnalysesEntity.class)
                    .build();

    public List<ResponseEntity> toResponseEntities(String objectType, List<?> result) {
        ObjectMapper mapper = new ObjectMapper();
        Class<? extends ConvertableToResponseEntity> responseClass = responseClasses.get(objectType);
        return result.stream()
                .map(rawJson -> mapper.convertValue(rawJson, responseClass))
                .map(ConvertableToResponseEntity::toResponse)
                .collect(toList());
    }
}