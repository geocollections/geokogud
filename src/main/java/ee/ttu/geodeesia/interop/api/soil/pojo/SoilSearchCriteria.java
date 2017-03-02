package ee.ttu.geodeesia.interop.api.soil.pojo;

import ee.ttu.geodeesia.search.domain.SearchField;
import ee.ttu.geodeesia.search.domain.SortField;

public class SoilSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField locality;
    private SearchField areaOfStudy;
    private SearchField transect;
    private SearchField soilName;
    private SearchField landUse;
    private boolean deepMining;

    public SearchField getId() {
        return id;
    }

    public void setId(SearchField id) {
        this.id = id;
    }

    public SearchField getLocality() {
        return locality;
    }

    public void setLocality(SearchField locality) {
        this.locality = locality;
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

    public boolean isDeepMining() {
        return deepMining;
    }

    public void setDeepMining(boolean deepMining) {
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
