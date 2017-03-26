package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentSampleSearchApiBuilder extends FluentSearchApiBuilder<FluentSampleSearchApiBuilder>{

    public static FluentSampleSearchApiBuilder aRequest() {
        return new FluentSampleSearchApiBuilder();
    }

    @Override
    FluentSampleSearchApiBuilder getThis() {
        return this;
    }

    public FluentSampleSearchApiBuilder queryId(SearchField id) {
        query += buildFieldParameters(ID, id);
        return this;
    }

    public FluentSampleSearchApiBuilder queryNumber(SearchField number) {
        query += buildFieldParameters(NUMBER, number);
        return this;
    }

    public FluentSampleSearchApiBuilder queryStratigraphy(SearchField stratigraphy) {
        query += buildFieldParameters(STRATIGRAPHY_STRATIGRAPHY, stratigraphy);
        return this;
    }

    public FluentSampleSearchApiBuilder queryStratigraphyBed(SearchField stratigraphyBed) {
        query += buildFieldParameters(STRATIGRAPHY_BED, stratigraphyBed);
        return this;
    }

    public FluentSampleSearchApiBuilder queryLocation(SearchField location) {
        query += buildFieldParameters(LOCATION, location);
        return this;
    }

    public FluentSampleSearchApiBuilder querySoilSiteId(SearchField soilSiteId) {
        query += buildFieldParameters(SOIL_SITE_ID, soilSiteId);
        return this;
    }

    public FluentSampleSearchApiBuilder queryMass(SearchField mass) {
        query += buildFieldParameters(MASS, mass);
        return this;
    }

    public FluentSampleSearchApiBuilder queryAgent(SearchField agent) {
        query += buildFieldParameters(AGENT_COLLECTED, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder queryTaxon(SearchField agent) {
        query += buildFieldParameters(TAXON, agent);
        return this;
    }


    public FluentSampleSearchApiBuilder queryAnalysis(SearchField agent) {
        query += buildFieldParameters(ANALYSIS, agent);
        return this;
    }

    public FluentSampleSearchApiBuilder queryFrequency(SearchField agent) {
        query += buildFieldParameters(FREQUENCY, agent);
        return this;
    }
    public FluentSampleSearchApiBuilder queryComponet(SearchField agent) {
        query += buildFieldParameters(COMPONENT, agent);
        return this;
    }
    public FluentSampleSearchApiBuilder queryContent(SearchField agent) {
        query += buildFieldParameters(CONTENT, agent);
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