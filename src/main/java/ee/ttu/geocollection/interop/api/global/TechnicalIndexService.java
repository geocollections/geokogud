package ee.ttu.geocollection.interop.api.global;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;

import java.io.IOException;
import java.util.Collection;


public interface TechnicalIndexService {
    void createIndex(Collection<Document> documents, Directory directory);

    Collection<Document> searchInIndex(QueryParameters queryParameters, Directory directory);

    default void writeIndex(Document document, IndexWriter indexWriter) {
        try {
            indexWriter.addDocument(document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
