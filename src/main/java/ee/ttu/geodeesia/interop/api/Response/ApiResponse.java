package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ttu.geodeesia.interop.api.analyses.pojo.AnalysesEntity;
import ee.ttu.geodeesia.interop.api.drillCores.pojo.DrillCoresEntity;
import ee.ttu.geodeesia.interop.api.localities.pojo.LocalityEntity;
import ee.ttu.geodeesia.interop.api.photoArchive.pojo.PhotoArchiveEntity;
import ee.ttu.geodeesia.interop.api.reference.pojo.ReferenceEntity;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleEntity;
import ee.ttu.geodeesia.interop.api.specimen.pojo.SpecimenEntity;
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
