package ee.ttu.geocollection.interop.api.soil.pojo;

import ee.ttu.geocollection.search.domain.SearchField;
import ee.ttu.geocollection.search.domain.SortField;

public class SoilSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField site;
    private SearchField areaOfStudy;
    private SearchField transect;
    private SearchField soilName;
    private SearchField landUse;
    private SearchField deepMining;

    public SearchField getId() { return id; }

    public void setId(SearchField id) {
        this.id = id;
    }

    public SearchField getSite() {
        return site;
    }

    public void setSite(SearchField site) {
        this.site = site;
    }

    public SearchField getAreaOfStudy() {
        return areaOfStudy;
    }

    public void setAreaOfStudy(SearchField areaOfStudy) {
        this.areaOfStudy = areaOfStudy;
    }

    public SearchField getTransect() {
        return transect;
    }

    public void setTransect(SearchField transect) {
        this.transect = transect;
    }

    public SearchField getSoilName() {
        return soilName;
    }

    public void setSoilName(SearchField soilName) {
        this.soilName = soilName;
    }

    public SearchField getLandUse() {
        return landUse;
    }

    public void setLandUse(SearchField landUse) {
        this.landUse = landUse;
    }

    public SearchField getDeepMining() { return deepMining; }

    public void setDeepMining(SearchField deepMining) {
        this.deepMining = deepMining;
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
}
