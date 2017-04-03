package ee.ttu.geocollection.interop.api.samples.pojo;

import ee.ttu.geocollection.search.domain.SearchField;
import ee.ttu.geocollection.search.domain.SortField;

import java.util.List;

/**
 * Created by Olesja Senkiv on 17.03.2017.
 */
public class SampleSearchCriteria {
    private int page = 1;
    private SortField sortField;
    private SearchField id;
    private SearchField sampleNumber;

    private SearchField depth;
    private SearchField stratigraphy;
    private SearchField stratigraphyBed;
    private SearchField agent;
    private SearchField mass;
    private SearchField location;
    private SearchField taxon;
    private SearchField frequency;
    private SearchField analysis;
    private SearchField component;
    private SearchField content;
    private List<String> dbs;

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

    public SearchField getMass() {
        return mass;
    }

    public void setMass(SearchField mass) {
        this.mass = mass;
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

    public SearchField getAnalysis() {
        return analysis;
    }

    public void setAnalysis(SearchField analysis) {
        this.analysis = analysis;
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
