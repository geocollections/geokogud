package ee.ttu.geocollection.interop.api.global;

import java.util.ArrayList;
import java.util.Collection;

public class QueryParameters {
    private Collection<QueryParam> fieldValuePairs = new ArrayList<>();

    private QueryParameters() {
    }

    public static QueryParameters params() {
        return new QueryParameters();
    }

    public QueryParameters appendParameter(String field, String value, DataType dataType) {
        fieldValuePairs.add(new QueryParam(field, value, dataType));
        return this;
    }

    public Collection<QueryParam> getFieldValuePairs() {
        return fieldValuePairs;
    }
}
