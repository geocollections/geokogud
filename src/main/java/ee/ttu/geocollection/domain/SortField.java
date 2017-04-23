package ee.ttu.geocollection.domain;

public class SortField {
    private String sortBy = "id";
    private SortingOrder order = SortingOrder.ASCENDING;

    public SortField() {
    }

    public SortField(String sortBy, SortingOrder order) {
        this.sortBy = sortBy;
        this.order = order;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public SortingOrder getOrder() {
        return order;
    }

    public void setOrder(SortingOrder order) {
        this.order = order;
    }
}
