package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.ID;
import static ee.ttu.geodeesia.interop.api.builder.ApiFields.REMARKS;

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
        buildFieldParameters(ID, id);
        return getThis();
    }


    public B queryInstitution(List<String> dbs) {
        if(dbs == null) return getThis();
        query += dbs.size() > 0 ?"&database__acronym=" +
                dbs.stream().collect(Collectors.joining("&database__acronym=")) : StringUtils.EMPTY;
        return getThis();
    }

    public B queryDepth(SearchField depth) {
        buildFieldParameters("depth", depth);
        return getThis();
    }

    public B returnRemarks() {
        addReturningField(REMARKS);
        return getThis();
    }

    public B fieldIsNotNull(String field) {
        query += "&" + field + "__isnull=false";
        return getThis();
    }

    void addReturningField(String field) {
        returnFields += returnFields.isEmpty() ? field : "," + field;
    }


    public String build() {
        return query + "&fields=" + returnFields;
    }
    /*
        Accept search query but do not return certain fields but all by default
     */
    public String buildWithoutReturningCertainFields() {
        return query;
    }

    void buildFieldParameters(String fieldName, SearchField searchField) {
        this.lastQueryField = fieldName;
        query += isNotNullAndEmpty(searchField) ? "&" + fieldName + "__" + extractFieldParameters(searchField) : StringUtils.EMPTY;
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
