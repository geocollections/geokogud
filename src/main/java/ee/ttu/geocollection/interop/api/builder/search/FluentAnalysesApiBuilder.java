package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
public class FluentAnalysesApiBuilder  extends FluentSearchApiBuilder<FluentAnalysesApiBuilder> {

    public static FluentAnalysesApiBuilder aRequest() {
        return new FluentAnalysesApiBuilder();
    }

    public FluentAnalysesApiBuilder querySample(SearchField sample) {
        buildFieldParameters(SAMPLE, sample);
        return this;
    }
    public FluentAnalysesApiBuilder queryStratigraphyBed(SearchField field) {
        buildFieldParameters(SAMPLE_STRATIGRAPHY_BED, field);
        return this;
    }
    public FluentAnalysesApiBuilder queryLocality(SearchField location) {
        buildMultiSearch(location, "sample__locality__locality", "sample__locality__locality_en");
        return this;
    }

    public FluentAnalysesApiBuilder queryAdminUnit(SearchField adminUnit) {
        buildMultiSearch(adminUnit,
                "sample__locality__country__value",
                "sample__locality__country__value_en",
                "sample__locality__maakond__maakond",
                "sample__locality__maakond__maakond_en",
                "sample__locality__vald__vald",
                "sample__locality__vald__vald_en",
                "sample__locality__asustusyksus__asustusyksus",
                "sample__locality__asustusyksus__asustusyksus_en");
        return this;
    }

    public FluentAnalysesApiBuilder queryStratigraphy(SearchField stratigraphy) {
        buildMultiSearch(stratigraphy,
                "sample__stratigraphy__stratigraphy",
                "sample__stratigraphy__stratigraphy_en",
                "sample__lithostratigraphy__stratigraphy",
                "sample__lithostratigraphy__stratigraphy_en");
        return this;
    }

    public FluentAnalysesApiBuilder queryDepth(SearchField depth) {
        buildMultiSearch(depth, SAMPLE_DEPTH, SAMPLE_DEPTH_INTERVAL);
        return this;
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
