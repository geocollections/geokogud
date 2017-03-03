package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
//AFTER ALL REFACTOR THIS CLASS WILL BE ApiResponse
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewVersionOfApiResponse {
    @JsonProperty("count")
    private int count;

    private String pageInfo;

    private List<?> results;

    private int numberOfPages;

    private int currentPage;

    public String getPageInfo() {
        return pageInfo;
    }

    @JsonProperty("page")
    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonProperty("result")
    public List<?> getResults() {
        return results;
    }
    @JsonProperty("results")
    public void setResults(List<?> results) {
        this.results = results;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
