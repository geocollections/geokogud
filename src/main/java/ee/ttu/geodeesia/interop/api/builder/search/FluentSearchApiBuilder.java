package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;
import org.apache.commons.lang3.StringUtils;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public abstract class FluentSearchApiBuilder<B extends FluentSearchApiBuilder<B>> {
    String query = StringUtils.EMPTY;
    private String returnFields = StringUtils.EMPTY;
    String lastQueryField = StringUtils.EMPTY;

    FluentSearchApiBuilder() {
    }

    abstract B getThis();

    public B andReturn() {
        addReturningField(lastQueryField);
        return getThis();
    }

    public B queryId(SearchField id) {
        query += buildFieldParameters(ID, id);
        return getThis();
    }

    public FluentSearchApiBuilder fieldIsNotNull(String field) {
        query += "&" + field + "__isnull=false";
        return this;
    }

    void addReturningField(String field) {
        returnFields += returnFields.isEmpty() ? field : "," + field;
    }


    public String build() {
        return query + "&fields=" + returnFields;
    }

    String buildFieldParameters(String fieldName, SearchField searchField) {
        this.lastQueryField = fieldName;
        return isNotNullAndEmpty(searchField) ? "&" + fieldName + "__" + extractFieldParameters(searchField) : StringUtils.EMPTY;
    }

    private String extractFieldParameters(SearchField searchField) {
        return searchField.getLookUpType().value() + "=" + searchField.getName();
    }

    private boolean isNotNullAndEmpty(SearchField field) {
        return field != null && StringUtils.isNotBlank(field.getName());
    }

    String booleanToString(Boolean flag) {
        return flag ? "1" : "0";
    }
}
