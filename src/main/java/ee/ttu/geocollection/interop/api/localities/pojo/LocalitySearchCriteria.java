package ee.ttu.geocollection.interop.api.localities.pojo;

import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.PageableSearchCriteria;

public class LocalitySearchCriteria implements PageableSearchCriteria{
    private int page = 1;
    private SortField sortField;
    private SearchField id;
    private SearchField searchImages;
    private SearchField stratigraphy;
    private SearchField number;
    private SearchField reference;
    private SearchField maId;
    private SearchField locality;
    private SearchField country;
    private SearchField adminUnit;
    private SearchField latitude;
    private SearchField longitude;
    private SearchField verticalExtentSince;
    private SearchField verticalExtentTo;

    public SearchField getSearchImages() {
        return searchImages;
    }

    public void setSearchImages(SearchField searchImages) {
        this.searchImages = searchImages;
    }

    public SearchField getCountry() {
        return country;
    }

    public void setCountry(SearchField country) {
        this.country = country;
    }

    public SearchField getAdminUnit() {
        return adminUnit;
    }

    public void setAdminUnit(SearchField adminUnit) {
        this.adminUnit = adminUnit;
    }

    public SearchField getVerticalExtentSince() {
        return verticalExtentSince;
    }

    public void setVerticalExtentSince(SearchField verticalExtentSince) {
        this.verticalExtentSince = verticalExtentSince;
    }

    public SearchField getVerticalExtentTo() {
        return verticalExtentTo;
    }

    public void setVerticalExtentTo(SearchField verticalExtentTo) {
        this.verticalExtentTo = verticalExtentTo;
    }

    public SearchField getLocality() {
        return locality;
    }

    public void setLocality(SearchField locality) {
        this.locality = locality;
    }

    public SearchField getMaId() {
        return maId;
    }

    public void setMaId(SearchField maId) {
        this.maId = maId;
    }

    public SearchField getReference() {
        return reference;
    }

    public void setReference(SearchField reference) {
        this.reference = reference;
    }

    public SearchField getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(SearchField stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public SearchField getNumber() {
        return number;
    }

    public void setNumber(SearchField number) {
        this.number = number;
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

    public SearchField getLatitude() {
        return latitude;
    }

    public void setLatitude(SearchField latitude) {
        this.latitude = latitude;
    }

    public SearchField getLongitude() {
        return longitude;
    }

    public void setLongitude(SearchField longitude) {
        this.longitude = longitude;
    }
}
