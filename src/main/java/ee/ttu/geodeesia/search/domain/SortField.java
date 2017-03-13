package ee.ttu.geodeesia.search.domain;

public class SortField {
    private String sortyBy = "id";
    private SortingOrder order = SortingOrder.ASCENDING;

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
