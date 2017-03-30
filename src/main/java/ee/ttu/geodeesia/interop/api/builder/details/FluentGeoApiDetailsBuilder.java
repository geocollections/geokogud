package ee.ttu.geodeesia.interop.api.builder.details;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class FluentGeoApiDetailsBuilder {
    private String query = EMPTY;
    private String returningFields = EMPTY;

    public static FluentGeoApiDetailsBuilder aRequest() {
        return new FluentGeoApiDetailsBuilder();
    }

    public FluentGeoApiDetailsBuilder id(Long id) {
        query += id;
        return this;
    }

    public FluentGeoApiDetailsBuilder relatedData(String relatedData) {
        query += relatedData;
        return this;
    }

    public FluentGeoApiDetailsBuilder returnCountryValue() {
        addReturningField("locality__country__value");
        return this;
    }

    public FluentGeoApiDetailsBuilder returnCountryValueEn() {
        addReturningField("locality__country__value_en");
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLatitude() {
        addReturningField("locality__latitude");
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLongitude() {
        addReturningField("locality__longitude");
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDepth() {
        addReturningField("depth");
        return this;
    }

    public FluentGeoApiDetailsBuilder returnBoxes() {
        addReturningField("boxes");
        return this;
    }

    private void addReturningField(String field) {
        returningFields += returningFields.isEmpty() ? field : "," + field;
    }

    public String buildWithDefaultReturningFields() {
        return query;
    }

    public String buildWithReturningFields() {
        return query + "?fields=" + returningFields;
    }
}
