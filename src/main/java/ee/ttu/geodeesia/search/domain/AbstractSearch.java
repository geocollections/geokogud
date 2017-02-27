package ee.ttu.geodeesia.search.domain;

public abstract class AbstractSearch {
    private String sort;
    private String sortDir = "ASC";
    private String currentTable;
    public AbstractSearch(){}
    public AbstractSearch(String currentTable) {
        this.currentTable = currentTable;
    }
}
