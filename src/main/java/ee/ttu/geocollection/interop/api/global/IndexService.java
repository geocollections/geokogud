package ee.ttu.geocollection.interop.api.global;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;


public interface IndexService {
    void createIndex();

    Collection<Document> searchInIndex(QueryParameters queryParameters);

    default void writeIndex(Document document, IndexWriter indexWriter) {
        try {
            indexWriter.addDocument(document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Document buildDocument(Map<String, Object> entry);
}
