package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

public class OrSearchPair {
    private SearchField searchField;
    private String field;

    public OrSearchPair(SearchField searchField, String field) {
        this.searchField = searchField;
        this.field = field;
    }

    public SearchField getSearchField() {
        return searchField;
    }

    public String getField() {
        return field;
    }
}