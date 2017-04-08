package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.search.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

public class FluentSoilSearchApiApiBuilder extends FluentSearchApiBuilder<FluentSoilSearchApiApiBuilder> {

    public static FluentSoilSearchApiApiBuilder aRequest() {
        return new FluentSoilSearchApiApiBuilder();
    }

    public FluentSoilSearchApiApiBuilder querySite(SearchField site) {
        buildFieldParameters(SITE, site);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryAreaName(SearchField areaName) {
        buildFieldParameters(AREA_NAME, areaName);
        return this;
    }

    public FluentSoilSearchApiApiBuilder querySoil(SearchField soil) {
        buildFieldParameters(SOIL, soil);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryLandUse(SearchField landUse) {
        buildFieldParameters(LAND_USE, landUse);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryTransect(SearchField transect) {
        buildFieldParameters(TRANSECT, transect);
        return this;
    }

    public FluentSoilSearchApiApiBuilder queryDeepMining(SearchField deep) {
       /*if (deep != null) {
            String isDeep = booleanToString(deep);
            query += "&" + IS_DEEP + "=" + isDeep;
            lastQueryField = IS_DEEP;
        }*/
        buildFieldParameters(IS_DEEP, deep);
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