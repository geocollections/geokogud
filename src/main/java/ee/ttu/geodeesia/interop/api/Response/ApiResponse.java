package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiAgent;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiGeolocation;
import ee.ttu.geodeesia.interop.api.doi.pojo.DoiRelatedIdentifier;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    @JsonProperty("count")
    private int count;
    @JsonProperty("page")
    private String pageInfo;
    @JsonProperty("results")
    private List<?> result;

    private RelatedData relatedData;

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

    @JsonProperty("relatedData")
    public RelatedData getRelatedData() {
        return relatedData;
    }
    @JsonProperty("related_data")
    public void setRelatedData(RelatedData relatedData) {
        this.relatedData = relatedData;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RelatedData {

        private List<DoiAgent> doiAgent;
        private List<DoiRelatedIdentifier> doiRelatedIdentifier;
        private List<DoiGeolocation> doiGeolocation;
        @JsonProperty("doiAgent")
        public List<DoiAgent> getDoiAgent() {
            return doiAgent;
        }
        @JsonProperty("doi_agent")
        public void setDoiAgent(List<DoiAgent> doiAgent) {
            this.doiAgent = doiAgent;
        }
        @JsonProperty("doiRelatedIdentifier")
        public List<DoiRelatedIdentifier> getDoiRelatedIdentifier() {
            return doiRelatedIdentifier;
        }
        @JsonProperty("doi_related_identifier")
        public void setDoiRelatedIdentifier(List<DoiRelatedIdentifier> doiRelatedIdentifier) {
            this.doiRelatedIdentifier = doiRelatedIdentifier;
        }
        @JsonProperty("doiGeolocation")
        public List<DoiGeolocation> getDoiGeolocation() {
            return doiGeolocation;
        }
        @JsonProperty("doi_geolocation")
        public void setDoiGeolocation(List<DoiGeolocation> doiGeolocation) {
            this.doiGeolocation = doiGeolocation;
        }
    }
}
