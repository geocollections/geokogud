package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.ID;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.REMARKS;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public abstract class FluentSearchApiBuilder<B extends FluentSearchApiBuilder<B>> {
    String query = EMPTY;
    private String returnFields = EMPTY;
    String lastQueryField = EMPTY;
    String[] lastQueryFields = new String[]{};

    FluentSearchApiBuilder() {
    }

    abstract B getThis();

    public B andReturn() {
        if (!lastQueryField.equals(EMPTY)) {
            addReturningField(lastQueryField);
            lastQueryField = EMPTY;
        }

        Stream.of(lastQueryFields).forEach(this::addReturningField);
        lastQueryFields = new String[]{};

        return getThis();
    }

    public B queryId(SearchField id) {
        buildFieldParameters(ID, id);
        return getThis();
    }


    public B queryInstitution(List<String> dbs) {
        if (dbs == null) return getThis();
        query += dbs.size() > 0 ? "&database__acronym=" +
                dbs.stream().collect(Collectors.joining("&database__acronym=")) : EMPTY;
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


    public String buildWithReturningCertainFields() {
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
        query += isNotNullAndEmpty(searchField) ? "&" + fieldName + "__" + extractFieldParameters(searchField) : EMPTY;
    }

    void buildMultiSearch(SearchField searchField, String... fieldName) {
        query += isNotNullAndEmpty(searchField) ?
                "&multi_search=value:" + searchField.getName()
                        + ";fields:" + StringUtils.join(fieldName, ",")
                        + ";lookuptype:" + searchField.getLookUpType()
                : EMPTY;
        this.lastQueryFields = fieldName;
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
