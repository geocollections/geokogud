package ee.ttu.geocollection.indexing.domain;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class DocumentBuilder {
    private Collection<Pair<String, FieldType>> fieldTypePairs = new ArrayList<>();
    private Map<String, Object> targetEntry;

    private DocumentBuilder() {
    }

    public static DocumentBuilder aDocument() {
        return new DocumentBuilder();
    }

    public DocumentBuilder targetEntry(Map<String, Object> targetEntry) {
        this.targetEntry = targetEntry;
        return this;
    }

    public DocumentBuilder withField(String field, FieldType fieldType) {
        Preconditions.checkNotNull(targetEntry);
        fieldTypePairs.add(new ImmutablePair<>(field, fieldType));
        return this;
    }

    public Document build() {
        Document document = new Document();
        fieldTypePairs.forEach(
                fieldStorePair ->
                        addFieldToDocumentIfPresent(
                                targetEntry,
                                fieldStorePair.getLeft(),
                                fieldStorePair.getRight(),
                                document));
        return document;
    }

    private void addFieldToDocumentIfPresent(Map<String, Object> entry, String fieldName, FieldType fieldType, Document document) {
        Object objectValue = entry.get(fieldName);
        if(objectValue != null) {
            String value = objectValue.toString();
            Field field = new Field(fieldName, value.toLowerCase(), fieldType);
            document.add(field);
        }
    }
}
