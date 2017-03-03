package ee.ttu.geodeesia.interop.api.builder;

import ee.ttu.geodeesia.search.domain.SearchField;
import org.apache.commons.lang3.StringUtils;

public class FluentGeoApiBuilder {

    private String query = StringUtils.EMPTY;

    private FluentGeoApiBuilder() {
    }

    public static FluentGeoApiBuilder aRequest() {
        return new FluentGeoApiBuilder();
    }

    public FluentGeoApiBuilder withId(SearchField id) {
        query += buildFieldParameters("id", id);
        return this;
    }

    public FluentGeoApiBuilder withSpecimenNumber(SearchField specimenNumber) {
        query += buildFieldParameters("specimen_nr", specimenNumber);
        return this;
    }

    public String build() {
        String result = query;
        query = StringUtils.EMPTY;
        return result;
    }

    private String buildFieldParameters(String fieldName, SearchField searchField) {
        return isNotNullAndEmpty(searchField) ? "&" + fieldName + "__" + extractFieldParameters(searchField) : StringUtils.EMPTY;
    }

    private String extractFieldParameters(SearchField searchField) {
        return searchField.getLookUpType().value() + "=" + searchField.getName();
    }

    private boolean isNotNullAndEmpty(SearchField field) {
        return field != null && StringUtils.isNotBlank(field.getName());
    }
}
