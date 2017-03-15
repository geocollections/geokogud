package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;
import static ee.ttu.geodeesia.interop.api.builder.ApiFields.IS_DEEP;

public class FluentSoilSearchApiApiBuilder extends FluentSearchApiBuilder<FluentSoilSearchApiApiBuilder> {

    public static FluentSoilSearchApiApiBuilder aRequest() {
        return new FluentSoilSearchApiApiBuilder();
    }

    public FluentSoilSearchApiApiBuilder querySite(SearchField site) {
        query += buildFieldParameters(SITE, site);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryAreaName(SearchField areaName) {
        query += buildFieldParameters(AREA_NAME, areaName);
        return this;
    }

    public FluentSoilSearchApiApiBuilder querySoil(SearchField soil) {
        query += buildFieldParameters(SOIL, soil);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryLandUse(SearchField landUse) {
        query += buildFieldParameters(LAND_USE, landUse);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryTransect(SearchField transect) {
        query += buildFieldParameters(TRANSECT, transect);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryDeepMining(Boolean deep) {
        if (deep != null) {
            String isDeep = booleanToString(deep);
            query += "&" + IS_DEEP + "=" + isDeep;
            lastQueryField = IS_DEEP;
        }
        return this;
    }

    public FluentSoilSearchApiApiBuilder returnTransectPoint() {
        addReturningField(TRANSECT_POINT);
        return this;
    }

    public FluentSoilSearchApiApiBuilder returnLatitude() {
        addReturningField(LATITUDE);
        return this;
    }

    public FluentSoilSearchApiApiBuilder returnLongitude() {
        addReturningField(LONGITUDE);
        return this;
    }

    @Override
    FluentSoilSearchApiApiBuilder getThis() {
        return this;
    }
}