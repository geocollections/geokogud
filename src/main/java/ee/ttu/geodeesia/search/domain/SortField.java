package ee.ttu.geodeesia.search.domain;

public class SortField {
    private String sortyBy;
    private SortingOrder order;

    public String getSortyBy() {
        return sortyBy;
    }

    public void setSortyBy(String sortyBy) {
        this.sortyBy = sortyBy;
    }

    public SortingOrder getOrder() {
        return order;
    }

    public void setOrder(SortingOrder order) {
        this.order = order;
    }
}
