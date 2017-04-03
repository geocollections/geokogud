package ee.ttu.geocollection.interop.api.drillCores.pojo;

import ee.ttu.geocollection.search.domain.SearchField;
import ee.ttu.geocollection.search.domain.SortField;

import java.util.List;

public class DrillCoreSearchCriteria {
    private int page = 1;
    private SortField sortField;
    private SearchField id;
    private SearchField drillcore;
    private SearchField storage;
    private SearchField boxNumber;
    private SearchField localityCountry;
    private SearchField localityCountryEng;
    private SearchField latitude;
    private SearchField longitude;
    private SearchField depth;
    private SearchField boxes;
    private List<String> dbs;

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

    public SearchField getLocalityCountry() {
        return localityCountry;
    }

    public void setLocalityCountry(SearchField localityCountry) {
        this.localityCountry = localityCountry;
    }

    public SearchField getLocalityCountryEng() {
        return localityCountryEng;
    }

    public void setLocalityCountryEng(SearchField localityCountryEng) {
        this.localityCountryEng = localityCountryEng;
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

    public SearchField getDepth() {
        return depth;
    }

    public void setDepth(SearchField depth) {
        this.depth = depth;
    }

    public SearchField getBoxes() {
        return boxes;
    }

    public void setBoxes(SearchField boxes) {
        this.boxes = boxes;
    }

    public List<String> getDbs() {
        return dbs;
    }

    public void setDbs(List<String> dbs) {
        this.dbs = dbs;
    }
}
