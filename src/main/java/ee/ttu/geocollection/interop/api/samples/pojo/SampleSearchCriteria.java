package ee.ttu.geocollection.interop.api.samples.pojo;

import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;

import java.util.List;

public class SampleSearchCriteria {
    private int page = 1;
    private SortField sortField;
    private SearchField id;
    private SearchField sampleNumber;

    private SearchField depthSince;
    private SearchField depthTo;
    private SearchField stratigraphy;
    private SearchField stratigraphyBed;
    private SearchField agent;
    private SearchField massSince;
    private SearchField massTo;
    private SearchField location;
    private SearchField taxon;
    private SearchField frequency;
    private SearchField analysisMethod;
    private SearchField component;
    private SearchField content;
    private SearchField locality;
    private SearchField country;
    private List<String> dbs;

    public SearchField getCountry() {
        return country;
    }

    public void setCountry(SearchField country) {
        this.country = country;
    }

    public SearchField getLocality() {
        return locality;
    }

    public void setLocality(SearchField locality) {
        this.locality = locality;
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

    public SearchField getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(SearchField sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public SearchField getDepthSince() {
        return depthSince;
    }

    public void setDepthSince(SearchField depthSince) {
        this.depthSince = depthSince;
    }

    public SearchField getDepthTo() {
        return depthTo;
    }

    public void setDepthTo(SearchField depthTo) {
        this.depthTo = depthTo;
    }

    public SearchField getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(SearchField stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public SearchField getStratigraphyBed() {
        return stratigraphyBed;
    }

    public void setStratigraphyBed(SearchField stratigraphyBed) {
        this.stratigraphyBed = stratigraphyBed;
    }

    public SearchField getAgent() {
        return agent;
    }

    public void setAgent(SearchField agent) {
        this.agent = agent;
    }

    public SearchField getMassSince() {
        return massSince;
    }

    public void setMassSince(SearchField massSince) {
        this.massSince = massSince;
    }

    public SearchField getMassTo() {
        return massTo;
    }

    public void setMassTo(SearchField massTo) {
        this.massTo = massTo;
    }

    public SearchField getLocation() {
        return location;
    }

    public void setLocation(SearchField location) {
        this.location = location;
    }

    public SearchField getTaxon() {
        return taxon;
    }

    public void setTaxon(SearchField taxon) {
        this.taxon = taxon;
    }

    public SearchField getFrequency() {
        return frequency;
    }

    public void setFrequency(SearchField frequency) {
        this.frequency = frequency;
    }

    public SearchField getAnalysisMethod() {
        return analysisMethod;
    }

    public void setAnalysisMethod(SearchField analysisMethod) {
        this.analysisMethod = analysisMethod;
    }

    public SearchField getComponent() {
        return component;
    }

    public void setComponent(SearchField component) {
        this.component = component;
    }

    public SearchField getContent() {
        return content;
    }

    public void setContent(SearchField content) {
        this.content = content;
    }

    public List<String> getDbs() {
        return dbs;
    }

    public void setDbs(List<String> dbs) {
        this.dbs = dbs;
    }
}
