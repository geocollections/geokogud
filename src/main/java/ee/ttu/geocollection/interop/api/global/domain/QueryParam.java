package ee.ttu.geocollection.interop.api.global.domain;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

public class QueryParam {
    private Triple<String, String, DataType> fieldValueType;

    public QueryParam(String field, String value, DataType dataType) {
        fieldValueType = new ImmutableTriple<>(field, value, dataType);
    }

    public String getField() {
        return fieldValueType.getLeft();
    }

    public String getValue() {
        return fieldValueType.getMiddle();
    }

    public DataType getDataType() {
        return fieldValueType.getRight();
    }
}
