package ee.ttu.geodeesia.search.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 48707222248 on 21.02.2017.
 */
public class SampleSearch extends AbstractSearch{

    private int page = 1; //set default 1 page
    private String sortDir = "ASC"; //set default sortDir
    private int maxSize = 5;
    private String table = "SAMPLES";

    private SearchField id;
    private SearchField sampleNumber;
    //Leiukoht
    private SearchField locality;
    //admin. yksus
    private SearchField country;
    //sügavus
    private SearchField depth;
    //stratigraafia
    private SearchField stratigraphy;
    //bed name / index
    private SearchField stratigraphyBed;
    //koguja
    private SearchField agent;
    //kaal
    private SearchField mass;
    //hoiukoht
    private SearchField location;
    //Taksoni nimi
    private SearchField taxon;
    //Taksoni arvukus
    private SearchField frequency;
    //Analyysi tyyp
    private SearchField analysis;
    //Analyysitud komponent
    private SearchField component;
    //Komponendi sisaldus
    private SearchField content;
    //Asutused.
    private List<String> dbs = new ArrayList<>(); // database__acronym?

    public SampleSearch(){}
    public SampleSearch(String name) {
        super(name);
        this.table = name;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public SearchField getLocality() {
        return locality;
    }

    public void setLocality(SearchField locality) {
        this.locality = locality;
    }

    public SearchField getCountry() {
        return country;
    }

    public void setCountry(SearchField country) {
        this.country = country;
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
