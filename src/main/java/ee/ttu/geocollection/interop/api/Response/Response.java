package ee.ttu.geocollection.interop.api.Response;

import java.util.List;

public class Response<T> {
    private int count;
    private List<T> result;
    private ApiResponse.RelatedData relatedData;
    private int numberOfPages;
    private int currentPage;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public ApiResponse.RelatedData getRelatedData() {
        return relatedData;
    }

    public void setRelatedData(ApiResponse.RelatedData relatedData) {
        this.relatedData = relatedData;
    }
}
