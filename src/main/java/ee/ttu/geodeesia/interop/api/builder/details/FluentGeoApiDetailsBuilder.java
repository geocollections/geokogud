package ee.ttu.geodeesia.interop.api.builder.details;

import org.apache.commons.lang3.StringUtils;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentGeoApiDetailsBuilder {
    private String query = StringUtils.EMPTY;

    public static FluentGeoApiDetailsBuilder aRequest() {
        return new FluentGeoApiDetailsBuilder();
    }

    public FluentGeoApiDetailsBuilder id(Long id) {
        query += id + "?fields=";
        return this;
    }

    public FluentGeoApiDetailsBuilder returnId() {
        query += addReturningField(ID);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnSite() {
        query += addReturningField(SITE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnAreaName() {
        query += addReturningField(AREA_NAME);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLandUse() {
        query += addReturningField(LAND_USE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnSoil() {
        query += addReturningField(SOIL);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnTransect() {
        query += addReturningField(TRANSECT);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnTransectPoint() {
        query += addReturningField(TRANSECT_POINT);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLatitude() {
        query += addReturningField(LATITUDE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLongitude() {
        query += addReturningField(LONGITUDE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDeepMining() {
        query += addReturningField(IS_DEEP);
        return this;
    }

    private String addReturningField(String field) {
        return isFirstField() ? field : "," + field;
    }

    private boolean isFirstField() {
        return "=".equals(StringUtils.right(query, 1));
    }

    public String build() {
        return query;
    }
}
