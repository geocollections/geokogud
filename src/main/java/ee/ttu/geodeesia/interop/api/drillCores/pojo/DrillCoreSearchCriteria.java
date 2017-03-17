package ee.ttu.geodeesia.interop.api.drillCores.pojo;

import ee.ttu.geodeesia.search.domain.SearchField;
import ee.ttu.geodeesia.search.domain.SortField;

/**
 * Created by Olesja Senkiv on 17.03.2017.
 */
public class DrillCoreSearchCriteria {
    private int page = 1;
    private SortField sortField;
    private SearchField id;
    private SearchField drillcore;
    private SearchField storage;
    private SearchField boxNumber;
    //    Country, Admin. unit, Stratigraphy


    public SearchField getId() {
        return id;
    }

    public void setId(SearchField id) {
        this.id = id;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
    }

    public SearchField getDrillcore() {
        return drillcore;
    }

    public void setDrillcore(SearchField drillcore) {
        this.drillcore = drillcore;
    }

    public SearchField getStorage() {
        return storage;
    }

    public void setStorage(SearchField storage) {
        this.storage = storage;
    }

    public SearchField getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(SearchField boxNumber) {
        this.boxNumber = boxNumber;
    }
}
