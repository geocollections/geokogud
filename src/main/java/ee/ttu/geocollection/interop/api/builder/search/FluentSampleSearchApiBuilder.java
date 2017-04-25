package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

public class FluentSampleSearchApiBuilder extends FluentSearchApiBuilder<FluentSampleSearchApiBuilder>{

    public static FluentSampleSearchApiBuilder aRequest() {
        return new FluentSampleSearchApiBuilder();
    }

    @Override
    FluentSampleSearchApiBuilder getThis() {
        return this;
    }

    public FluentSampleSearchApiBuilder queryId(SearchField id) {
        buildFieldParameters(ID, id);
        return this;
    }

    public FluentSampleSearchApiBuilder queryNumber(SearchField number) {
        buildMultiSearch(number, NUMBER, NUMBER_ADDITIONAL, NUMBER_FIELD, ID);
        return this;
    }

    public FluentSampleSearchApiBuilder queryStratigraphy(SearchField stratigraphy) {
        buildMultiSearch(stratigraphy,
                STRATIGRAPHY_STRATIGRAPHY,
                STRATIGRAPHY_STRATIGRAPHY_ENG,
                LITHOSTRATIGRAPHY__STRATIGRAPHY,
                LITHOSTRATIGRAPHY__STRATIGRAPHY_ENG,
                STRATIGRAPHY_FREE);
        return this;
    }

    public FluentSampleSearchApiBuilder queryStratigraphyBed(SearchField stratigraphyBed) {
        buildMultiSearch(stratigraphyBed, STRATIGRAPHY_BED, STRATIGRAPHY_STRATIGRAPHY_ENG);
        return this;
    }

    public FluentSampleSearchApiBuilder queryLocality(SearchField location) {
        buildMultiSearch(location, LOCALITY_LOCALITY, LOCALITY_LOCALITY_EN, LOCALITY_FREE);
        return this;
    }

    public FluentSampleSearchApiBuilder queryCountry(SearchField country) {
        buildMultiSearch(country,
                LOCALITY_COUNTRY,
                LOCALITY_COUNTRY_ENG,
                LOCALITY__COUNTRY__ISO_CODE,
                LOCALITY__MAAKOND__MAAKOND,
                LOCALITY__MAAKOND__MAAKOND_EN,
                LOCALITY__VALD__VALD,
                LOCALITY__VALD__VALD_ENG,
                LOCALITY__ASUSTUSYKSUS__ASUSTUSYKSUS,
                LOCALITY__ASUSTUSYKSUS__ASUSTUSYKSUS_EN);
        return this;
    }

    @Override
    public FluentSampleSearchApiBuilder queryDepth(SearchField depth) {
        buildMultiSearch(depth, DEPTH, DEPTH_INTERVAL);
        return this;
    }

    public FluentSampleSearchApiBuilder querySoilSiteId(SearchField soilSiteId) {
        buildFieldParameters(SOIL_SITE_ID, soilSiteId);
        return this;
    }

    public FluentSampleSearchApiBuilder queryMass(SearchField mass) {
        buildFieldParameters(MASS, mass);
        return this;
    }

    public FluentSampleSearchApiBuilder queryAgent(SearchField agent) {
        buildFieldParameters(AGENT_COLLECTED, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder queryTaxon(SearchField agent) {
        buildFieldParameters(TAXONLIST__TAXON__TAXON, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder queryAnalysisMethod(SearchField analysisMethod) {
        buildMultiSearch(analysisMethod, ANALYSIS_METHOD, ANALYSIS_METHOD_EN);
        return this;
    }

    public FluentSampleSearchApiBuilder queryFrequency(SearchField agent) {
        buildFieldParameters(TAXONLIST__FREQUENCY, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder queryComponet(SearchField agent) {
        buildFieldParameters(ANALYSIS_RESULTS_NAME, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder queryContent(SearchField agent) {
        buildFieldParameters(ANALYSIS_RESULTS_VALUE, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder returnNumber() {
        addReturningField(NUMBER);
        return this;
    }

    public FluentSampleSearchApiBuilder returnNumberAdditional() {
        addReturningField(NUMBER_ADDITIONAL);
        return this;
    }

    public FluentSampleSearchApiBuilder returnDepthInterval() {
        addReturningField(DEPTH_INTERVAL);
        return this;
    }

    public FluentSampleSearchApiBuilder returnAnalyzed() {
        addReturningField(ANALYZED);
        return this;
    }

    public FluentSampleSearchApiBuilder queryLocation(SearchField location) {
        buildFieldParameters(LOCATION, location);
        return this;
    }
}