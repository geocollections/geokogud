package ee.ttu.geocollection.indexing.domain;

import org.apache.lucene.document.Document;

import java.util.Collection;

public class SearchResult {
    private String table;
    private Collection<Document> documents;

    public SearchResult(String table, Collection<Document> documents) {
        this.table = table;
        this.documents = documents;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }
}
