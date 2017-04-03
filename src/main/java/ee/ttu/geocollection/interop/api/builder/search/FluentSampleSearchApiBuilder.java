package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.search.domain.SearchField;

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
        buildFieldParameters(NUMBER, number);
        return this;
    }

    public FluentSampleSearchApiBuilder queryStratigraphy(SearchField stratigraphy) {
        buildFieldParameters(STRATIGRAPHY_STRATIGRAPHY, stratigraphy);
        return this;
    }

    public FluentSampleSearchApiBuilder queryStratigraphyBed(SearchField stratigraphyBed) {
        buildFieldParameters(STRATIGRAPHY_BED, stratigraphyBed);
        return this;
    }

    public FluentSampleSearchApiBuilder queryLocation(SearchField location) {
        buildFieldParameters(LOCATION, location);
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
        buildFieldParameters(TAXON, agent);
        return this;
    }


    public FluentSampleSearchApiBuilder queryAnalysis(SearchField agent) {
        buildFieldParameters(ANALYSIS, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder queryFrequency(SearchField agent) {
        buildFieldParameters(FREQUENCY, agent);
        return this;
    }
    public FluentSampleSearchApiBuilder queryComponet(SearchField agent) {
        buildFieldParameters(COMPONENT, agent);
        return this;
    }
    public FluentSampleSearchApiBuilder queryContent(SearchField agent) {
        buildFieldParameters(CONTENT, agent);
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

}