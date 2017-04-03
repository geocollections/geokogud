package ee.ttu.geocollection.interop.api.builder.details;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class FluentGeoApiDetailsBuilder {
    private String query = EMPTY;
    private String returningFields = EMPTY;
    private String relatedData = EMPTY;

    public static FluentGeoApiDetailsBuilder aRequest() {
        return new FluentGeoApiDetailsBuilder();
    }

    public FluentGeoApiDetailsBuilder id(Long id) {
        query += id;
        return this;
    }

    public FluentGeoApiDetailsBuilder relatedData(String relatedData) {
        query += query.contains("?") ? "&related_data=" + relatedData : "?related_data=" + relatedData;
        return this;
    }

    private void addReturningField(String field) {
        returningFields += returningFields.isEmpty() ? field : "," + field;
    }

    public String buildWithDefaultReturningFields() {
        return query;
    }

    public String buildWithReturningFields() {
        return query;
    }
}
