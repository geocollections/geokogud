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

    public FluentSampleSearchApiBuilder querySoilSiteId(SearchField soilSiteId) {
        query += buildFieldParameters(SOIL_SITE_ID, soilSiteId);
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