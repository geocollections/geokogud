package ee.ttu.geocollection.interop.api.analyses.pojo;

import ee.ttu.geocollection.search.domain.SearchField;
import ee.ttu.geocollection.search.domain.SortField;

public class AnalysesSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
   /* private SearchField author;
    private SearchField title;
    private SearchField year;
    private SearchField doi;
    private SearchField publishedBy;
    private SearchField abstractText;*/

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

    public SearchField getId() {
        return id;
    }

    public void setId(SearchField id) {
        this.id = id;
    }

}
