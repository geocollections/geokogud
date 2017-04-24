package ee.ttu.geocollection.indexing.technical;

import ee.ttu.geocollection.indexing.domain.QueryParameters;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;

import java.util.Collection;


public interface TechnicalIndexService {
    void updateIndex(Collection<Document> documents, IndexWriter directoryWriter);

    void createIndex(Collection<Document> documents, IndexWriter directoryWriter);

    Collection<Document> searchInIndex(QueryParameters queryParameters, DirectoryReader indexReader);
}
