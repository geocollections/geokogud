package ee.ttu.geocollection.interop.api.taxon;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.PageableSearchCriteria;

public class TaxonSearchCriteria implements PageableSearchCriteria {
    private SortField sortField;
    private int page;

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }
}
