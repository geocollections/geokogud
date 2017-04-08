package ee.ttu.geocollection.interop.api.analyses.pojo;

import ee.ttu.geocollection.search.domain.SearchField;
import ee.ttu.geocollection.search.domain.SortField;

public class AnalysesSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField analysisMethod;
    private SearchField analysisMethodEng;
    private SearchField methodDetails;
    private SearchField lab;
    private SearchField instrument;
    private SearchField instrumentTxt;
    private SearchField sample;
    private SearchField date;
    private SearchField dateFree;

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

    public SearchField getId() { return id; }

    public void setId(SearchField id) {
        this.id = id;
    }

    public SearchField getAnalysisMethod() { return analysisMethod; }

    public void setAnalysisMethod(SearchField analysisMethod) { this.analysisMethod = analysisMethod; }

    public SearchField getAnalysisMethodEng() { return analysisMethodEng; }

    public void setAnalysisMethodEng(SearchField analysisMethodEng) { this.analysisMethodEng = analysisMethodEng; }

    public SearchField getMethodDetails() { return methodDetails; }

    public void setMethodDetails(SearchField methodDetails) { this.methodDetails = methodDetails; }

    public SearchField getLab() { return lab; }

    public void setLab(SearchField lab) { this.lab = lab; }

    public SearchField getInstrument() { return instrument; }

    public void setInstrument(SearchField instrument) { this.instrument = instrument; }

    public SearchField getInstrumentTxt() { return instrumentTxt; }

    public void setInstrumentTxt(SearchField instrumentTxt) { this.instrumentTxt = instrumentTxt; }

    public SearchField getSample() { return sample; }

    public void setSample(SearchField sample) { this.sample = sample; }

    public SearchField getDate() { return date; }

    public void setDate(SearchField date) { this.date = date; }

    public SearchField getDateFree() { return dateFree; }

    public void setDateFree(SearchField dateFree) { this.dateFree = dateFree; }
}
