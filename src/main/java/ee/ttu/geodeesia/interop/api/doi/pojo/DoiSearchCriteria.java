package ee.ttu.geodeesia.interop.api.doi.pojo;

import ee.ttu.geodeesia.search.domain.SearchField;
import ee.ttu.geodeesia.search.domain.SortField;

public class DoiSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField author;
    private SearchField title;
    private SearchField year;
    private SearchField doi;
    private SearchField publishedBy;
    private SearchField abstractText;

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

    public SearchField getAuthor() {
        return author;
    }

    public void setAuthor(SearchField author) {
        this.author = author;
    }

    public SearchField getTitle() {
        return title;
    }

    public void setTitle(SearchField title) {
        this.title = title;
    }

    public SearchField getYear() {
        return year;
    }

    public void setYear(SearchField year) {
        this.year = year;
    }

    public SearchField getDoi() {
        return doi;
    }

    public void setDoi(SearchField doi) {
        this.doi = doi;
    }

    public SearchField getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(SearchField publishedBy) {
        this.publishedBy = publishedBy;
    }

    public SearchField getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(SearchField abstractText) {
        this.abstractText = abstractText;
    }
}
