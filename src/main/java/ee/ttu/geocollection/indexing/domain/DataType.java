package ee.ttu.geocollection.indexing.domain;

public enum DataType {
    /**
     * Corresponds to StringField field types (if there are just numbers)
     */
    NUMERIC,
    /**
     * Corresponds to StringField field types (if there are numbers + characters)
     */
    STRING,
    /**
     * Corresponds to TextField field types
     */
    TEXT;
}
