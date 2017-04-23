package ee.ttu.geocollection.interop.api.global.technical;

import ee.ttu.geocollection.interop.api.global.domain.QueryParameters;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;

import java.io.IOException;
import java.util.Collection;


public interface TechnicalIndexService {
    void createIndex(Collection<Document> documents, IndexWriter directoryWriter);

    Collection<Document> searchInIndex(QueryParameters queryParameters, DirectoryReader indexReader);

    default void writeIndex(Document document, IndexWriter indexWriter) {
        try {
            indexWriter.addDocument(document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
