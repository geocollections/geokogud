package ee.ttu.geocollection.interop.api.global;

import org.apache.lucene.document.Document;

import java.util.Collection;
import java.util.Map;

public interface IndexService {
    void createIndex();

    Document buildDocument(Map<String, Object> entry);

    Collection<Document> searchInIndex();
}
