package ee.ttu.geodeesia.interop.api.photoArchive.pojo;

import ee.ttu.geodeesia.search.domain.SearchField;
import ee.ttu.geodeesia.search.domain.SortField;

public class PhotoArchiveSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField fileName;
    private SearchField dateTaken;
    private SearchField authorAgent;
    private SearchField localityId;

/*    private SearchField doi;
    private SearchField title;
    private SearchField publishedBy;
    private SearchField year;
    private SearchField author;*/

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

    public SearchField getFileName() {
        return fileName;
    }

    public void setFileName(SearchField fileName) {
        this.fileName = fileName;
    }

    public SearchField getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(SearchField dateTaken) {
        this.dateTaken = dateTaken;
    }

    public SearchField getAuthorAgent() {
        return authorAgent;
    }

    public void setAuthorAgent(SearchField authorAgent) {
        this.authorAgent = authorAgent;
    }

    public SearchField getLocalityId() {
        return localityId;
    }

    public void setLocalityId(SearchField localityId) {
        this.localityId = localityId;
    }

    /* public SearchField getDoi() {
        return doi;
    }

    public void setDoi(SearchField doi) {
        this.doi = doi;
    }

    public SearchField getTitle() {
        return title;
    }

    public void setTitle(SearchField title) {
        this.title = title;
    }

    public SearchField getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(SearchField publishedBy) {
        this.publishedBy = publishedBy;
    }

    public SearchField getYear() {
        return year;
    }

    public void setYear(SearchField year) {
        this.year = year;
    }

    public SearchField getAuthor() {
        return author;
    }

    public void setAuthor(SearchField author) {
        this.author = author;
    }*/
}
