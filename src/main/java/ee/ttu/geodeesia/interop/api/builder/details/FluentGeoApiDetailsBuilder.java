package ee.ttu.geodeesia.interop.api.builder.details;

import org.apache.commons.lang3.StringUtils;

public class FluentGeoApiDetailsBuilder {
    private String query = StringUtils.EMPTY;

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
