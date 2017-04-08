package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.search.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
public class FluentAnalysesApiBuilder  extends FluentSearchApiBuilder<FluentAnalysesApiBuilder> {

    public static FluentAnalysesApiBuilder aRequest() {
        return new FluentAnalysesApiBuilder();
    }

    public FluentAnalysesApiBuilder queryAnalysisMethod(SearchField analysisMethod) {
        buildFieldParameters(ANALYSIS_METHOD__ANALYSIS_METHOD, analysisMethod);
        return this;
    }
    public FluentAnalysesApiBuilder queryAnalysisMethodEng(SearchField analysisMethodEng) {
        buildFieldParameters(ANALYSIS_METHOD__METHOD_EN, analysisMethodEng);
        return this;
    }
    public FluentAnalysesApiBuilder queryMethodDetails(SearchField methodDetails) {
        buildFieldParameters(METHOD_DETAILS, methodDetails);
        return this;
    }
    public FluentAnalysesApiBuilder queryLab(SearchField lab) {
        buildFieldParameters(LAB, lab);
        return this;
    }
    public FluentAnalysesApiBuilder queryInstrument(SearchField instrument) {
        buildFieldParameters(INSTRUMENT, instrument);
        return this;
    }
    public FluentAnalysesApiBuilder queryInstrumentTxt(SearchField instrumentTxt) {
        buildFieldParameters(INSTRUMENT_TXT, instrumentTxt);
        return this;
    }
    public FluentAnalysesApiBuilder querySample(SearchField sample) {
        buildFieldParameters(SAMPLE, sample);
        return this;
    }
    public FluentAnalysesApiBuilder queryDate(SearchField date) {
        buildFieldParameters(DATE, date);
        return this;
    }
    public FluentAnalysesApiBuilder queryDateFree(SearchField dateFree) {
        buildFieldParameters(DATE_FREE, dateFree);
        return this;
    }
    @Override
    FluentAnalysesApiBuilder getThis() { return this; }
}
