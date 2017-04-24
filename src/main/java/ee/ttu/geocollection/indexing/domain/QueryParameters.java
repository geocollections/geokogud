package ee.ttu.geocollection.indexing.domain;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collection;

public class QueryParameters {
    private Collection<QueryParam> fieldValuePairs = new ArrayList<>();
    private String queryValue;

    private QueryParameters() {
    }

    public static QueryParameters params() {
        return new QueryParameters();
    }

    public QueryParameters queryValue(String queryValue) {
        this.queryValue = queryValue.toLowerCase();
        return this;
    }

    public QueryParameters appendParameter(String field, DataType dataType) {
        Preconditions.checkNotNull(queryValue);
        fieldValuePairs.add(new QueryParam(field, queryValue, dataType));
        return this;
    }

    public Collection<QueryParam> getFieldValuePairs() {
        return fieldValuePairs;
    }
}
