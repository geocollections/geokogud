package ee.ttu.geocollection.interop.api.reference.pojo;

import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.PageableSearchCriteria;

public class ReferenceSearchCriteria implements PageableSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField author;
    private SearchField title;
    private SearchField yearSince;
    private SearchField yearTo;
    private SearchField doi;
    private SearchField book;
    private SearchField journal;

    public SearchField getBook() {
        return book;
    }

    public void setBook(SearchField book) {
        this.book = book;
    }

    public SearchField getJournal() {
        return journal;
    }

    public void setJournal(SearchField journal) {
        this.journal = journal;
    }

    public SearchField getId() {
        return id;
    }

    public void setId(SearchField id) {
        this.id = id;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
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

    public SearchField getYearSince() {
        return yearSince;
    }

    public void setYearSince(SearchField yearSince) {
        this.yearSince = yearSince;
    }

    public SearchField getYearTo() {
        return yearTo;
    }

    public void setYearTo(SearchField yearTo) {
        this.yearTo = yearTo;
    }

    public SearchField getDoi() {
        return doi;
    }

    public void setDoi(SearchField doi) {
        this.doi = doi;
    }
}
