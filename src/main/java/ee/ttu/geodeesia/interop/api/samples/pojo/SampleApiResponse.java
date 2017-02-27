package ee.ttu.geodeesia.interop.api.samples.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntities;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SampleApiResponse {
    @JsonProperty("count")
    private int count;
    @JsonProperty("page")
    private String pageInfo;
    @JsonProperty("results")
    private List<ApiServiceSample> result;

    public List<ResponseEntities> toResponseEntities() {
        List<ResponseEntities> list = new ArrayList<>();
        result.forEach(apiServiceSample -> {
            list.add(apiServiceSample.toResponse());
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

    public List<ApiServiceSample> getResult() {
        return result;
    }

    public void setResult(List<ApiServiceSample> result) {
        this.result = result;
    }
}
