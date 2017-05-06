package ee.ttu.geocollection.interop.api.builder.details;

import java.util.List;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
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
        this.relatedData += "&related_data=" + relatedData;
        return this;
    }

    public FluentGeoApiDetailsBuilder returnAllFields(List<String> fields) {
        fields.forEach(this::addReturningField);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnId() {
        addReturningField(ID);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnNumber() {
        addReturningField(NUMBER);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnNumberAdditional() {
        addReturningField(NUMBER_ADDITIONAL);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocality() {
        addReturningField(LOCALITY_LOCALITY);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityEn() {
        addReturningField(LOCALITY_LOCALITY_EN);
        return this;
    }

    private void addReturningField(String field) {
        returningFields += returningFields.isEmpty() ? field : "," + field;
    }

    public String buildWithDefaultReturningFields() {
        return query + replaceFirstAndWIthQuestionMark(this.relatedData);
    }

    private String replaceFirstAndWIthQuestionMark(String relatedData) {
        return "?" + relatedData.substring(1);
    }

    public String buildWithReturningFieldsAndRelatedData() {
        return query + (returningFields.isEmpty() ? replaceFirstAndWIthQuestionMark(this.relatedData) : "?fields=" + returningFields + relatedData) ;
    }
}
