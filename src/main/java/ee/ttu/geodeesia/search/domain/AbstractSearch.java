package ee.ttu.geodeesia.search.domain;

/**
 * Created by 48707222248 on 21.02.2017.
 */
public abstract class AbstractSearch {
    private String sort;
    private String sortDir = "ASC";
    private String currentTable;
    public AbstractSearch(){}
    public AbstractSearch(String currentTable) {
        this.currentTable = currentTable;
    }
}
