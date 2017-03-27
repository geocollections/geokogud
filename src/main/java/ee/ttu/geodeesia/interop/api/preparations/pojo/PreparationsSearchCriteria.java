package ee.ttu.geodeesia.interop.api.preparations.pojo;

import ee.ttu.geodeesia.search.domain.SearchField;
import ee.ttu.geodeesia.search.domain.SortField;

public class PreparationsSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField number;
    private SearchField locality;
    private SearchField localityEn;
    private SearchField depth;
    private SearchField stratigraphy;
    private SearchField stratigraphyEn;
    private SearchField collector;
    private SearchField description;
    private SearchField speciesRecovered;
    private SearchField speciesFrequency;

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

    public SearchField getLocalityEn() {
        return localityEn;
    }

    public void setLocalityEn(SearchField localityEn) {
        this.localityEn = localityEn;
    }

    public SearchField getStratigraphyEn() {
        return stratigraphyEn;
    }

    public void setStratigraphyEn(SearchField stratigraphyEn) {
        this.stratigraphyEn = stratigraphyEn;
    }

    public SearchField getNumber() {
        return number;
    }

    public void setNumber(SearchField number) {
        this.number = number;
    }

    public SearchField getLocality() {
        return locality;
    }

    public void setLocality(SearchField locality) {
        this.locality = locality;
    }

    public SearchField getDepth() {
        return depth;
    }

    public void setDepth(SearchField depth) {
        this.depth = depth;
    }

    public SearchField getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(SearchField stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public SearchField getCollector() {
        return collector;
    }

    public void setCollector(SearchField collector) {
        this.collector = collector;
    }

    public SearchField getDescription() {
        return description;
    }

    public void setDescription(SearchField description) {
        this.description = description;
    }

    public SearchField getSpeciesRecovered() {
        return speciesRecovered;
    }

    public void setSpeciesRecovered(SearchField speciesRecovered) {
        this.speciesRecovered = speciesRecovered;
    }

    public SearchField getSpeciesFrequency() {
        return speciesFrequency;
    }

    public void setSpeciesFrequency(SearchField speciesFrequency) {
        this.speciesFrequency = speciesFrequency;
    }
}
