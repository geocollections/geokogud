package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;
import ee.ttu.geodeesia.interop.api.analyses.pojo.AnalysesEntity;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoresEntity;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityEntity;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceEntity;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleEntity;
import ee.ttu.geodeesia.interop.api.stratigraphies.pojo.StratigraphyEnitity;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    @JsonProperty("count")
    private int count;
    @JsonProperty("page")
    private String pageInfo;
    @JsonProperty("results")
    private List<?> result;

    public List<ResponseEntity> toResponseEntities(String objectType) {
        List<ResponseEntity> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        result.forEach(apiEntity -> {
            switch (objectType) {
                case "specimen":
                    break;
                case "sample":
                    SampleEntity entity = mapper.convertValue(apiEntity, SampleEntity.class);
                    list.add(entity.toResponse());
                    break;
                case "drillcore":
                    DrillCoresEntity drillCoresEntity = mapper.convertValue(apiEntity, DrillCoresEntity.class);
                    list.add(drillCoresEntity.toResponse());
                    break;
                case "locality":
                    LocalityEntity localityEntity = mapper.convertValue(apiEntity, LocalityEntity.class);
                    list.add(localityEntity.toResponse());
                    break;
                case "reference":
                    ReferenceEntity referenceEntity = mapper.convertValue(apiEntity, ReferenceEntity.class);
                    list.add(referenceEntity.toResponse());
                    break;
                case "stratigraphy":
                    StratigraphyEnitity stratigraphyEnitity= mapper.convertValue(apiEntity, StratigraphyEnitity.class);
                    list.add(stratigraphyEnitity.toResponse());
                    break;
                case "analysis":
                    AnalysesEntity analysesEntity= mapper.convertValue(apiEntity, AnalysesEntity.class);
                    list.add(analysesEntity.toResponse());
                    break;
                default:
                    break;
            }

        });
        return list;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
