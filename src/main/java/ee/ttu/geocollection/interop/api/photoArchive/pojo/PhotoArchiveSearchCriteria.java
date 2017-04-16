package ee.ttu.geocollection.interop.api.photoArchive.pojo;

import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;

public class PhotoArchiveSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField fileName;
    private SearchField dateTakenSince;
    private SearchField dateTakenTo;
    private SearchField authorAgent;
    private SearchField locality;
    private SearchField keywords;
    private SearchField imageNumber;
    private SearchField people;
    private SearchField adminUnit;
    private SearchField sizeXYSince;
    private SearchField sizeXYTo;

    public SearchField getSizeXYSince() {
        return sizeXYSince;
    }

    public void setSizeXYSince(SearchField sizeXYSince) {
        this.sizeXYSince = sizeXYSince;
    }

    public SearchField getSizeXYTo() {
        return sizeXYTo;
    }

    public void setSizeXYTo(SearchField sizeXYTo) {
        this.sizeXYTo = sizeXYTo;
    }

    public SearchField getAdminUnit() {
        return adminUnit;
    }

    public void setAdminUnit(SearchField adminUnit) {
        this.adminUnit = adminUnit;
    }

    public SearchField getLocality() {
        return locality;
    }

    public void setLocality(SearchField locality) {
        this.locality = locality;
    }

    public SearchField getPeople() {
        return people;
    }

    public void setPeople(SearchField people) {
        this.people = people;
    }

    public SearchField getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(SearchField imageNumber) {
        this.imageNumber = imageNumber;
    }

    public SearchField getKeywords() {
        return keywords;
    }

    public void setKeywords(SearchField keywords) {
        this.keywords = keywords;
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

    public SearchField getDateTakenSince() {
        return dateTakenSince;
    }

    public void setDateTakenSince(SearchField dateTakenSince) {
        this.dateTakenSince = dateTakenSince;
    }

    public SearchField getDateTakenTo() {
        return dateTakenTo;
    }

    public void setDateTakenTo(SearchField dateTakenTo) {
        this.dateTakenTo = dateTakenTo;
    }

    public SearchField getAuthorAgent() {
        return authorAgent;
    }

    public void setAuthorAgent(SearchField authorAgent) {
        this.authorAgent = authorAgent;
    }
}
