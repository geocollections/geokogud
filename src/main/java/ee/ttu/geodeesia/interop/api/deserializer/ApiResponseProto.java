package ee.ttu.geodeesia.interop.api.deserializer;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseProto {
    @JsonProperty("count")
    private int count;
    @JsonProperty("page")
    private String pageInfo;
    @JsonProperty("results")
    private List<Map<String, String>> result;

    private Map<String, List<Map<String, String>>> relatedData;

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

    public List<Map<String, String>> getResult() {
        return result;
    }

    public void setResult(List<Map<String, String>> result) {
        this.result = result;
    }

    @JsonProperty("relatedData")
    public Map<String, List<Map<String, String>>> getRelatedData() {
        return relatedData;
    }

    @JsonProperty("related_data")
    public void setRelatedData(Map<String, List<Map<String, String>>> relatedData) {
        this.relatedData = relatedData;
    }
}
