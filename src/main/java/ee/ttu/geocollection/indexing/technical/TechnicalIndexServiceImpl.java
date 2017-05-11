package ee.ttu.geocollection.indexing.technical;

import com.google.common.base.Preconditions;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.QueryParam;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static ee.ttu.geocollection.indexing.technical.utils.IndexUtils.createDirectoryReader;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.ID;

@Service
public class TechnicalIndexServiceImpl implements TechnicalIndexService {

    public static final int SEARCH_RESULT_AMOUNT = 100;

    @Override
    public void updateIndex(Collection<Document> documents, IndexWriter directoryWriter) {
        try {
            for (Document document : documents) {
                directoryWriter.updateDocument(new Term(ID, document.get(ID)), document);
            }
            directoryWriter.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createIndex(Collection<Document> documents, IndexWriter directoryWriter) {
        try {
            for (Document document : documents) {
                directoryWriter.addDocument(document);
            }
            directoryWriter.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Document> searchInIndex(QueryParameters queryParameters, DirectoryReader indexReader) {
        Collection<Document> documents = new ArrayList<>();
        try {
            // TODO: WE HAVE A PROBLEM HERE, should look into it
            // let's say that indices got updated, then we want to update that exact IndexReader singleton,
            // not to create local copy of it each time we want to perform read...
            // can I somehow update bean spring singleton instance in the application..? don't think so tbh
            // BTW, according to http://stackoverflow.com/questions/15197028/why-i-cant-get-the-doc-that-added-recently-by-indexwriter-in-the-search-result
            // openIfChanged may return NULL if index reader DID not change! so it proves that I keep using that old index reader with basically no data
            // and just keep recreating new instance of it...
//            DirectoryReader indexReaderUpdated = DirectoryReader.openIfChanged(indexReader);
//            if (indexReaderUpdated != null) {
//                indexReader = indexReaderUpdated;
//            }
            indexReader = createDirectoryReader(indexReader);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);

            Query query = buildQuery(queryParameters);

            TopDocs topDocs = indexSearcher.search(query, SEARCH_RESULT_AMOUNT);
            ScoreDoc[] scoreDoc = topDocs.scoreDocs;
            for (ScoreDoc score : scoreDoc) {
                Document document = indexReader.document(score.doc);
                documents.add(document);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return documents;
    }

    private Query buildQuery(QueryParameters queryParameters) {
        BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
        queryParameters.getFieldValuePairs()
                .forEach(queryParam -> queryBuilder.add(buildQueryClause(queryParam)));
        return queryBuilder.build();
    }

    private BooleanClause buildQueryClause(QueryParam queryParam) {
        Query query = null;
        if (queryParam.getDataType() == DataType.NUMERIC) {
            query = new TermQuery(new Term(queryParam.getField(), queryParam.getValue()));
        } else if (queryParam.getDataType() == DataType.STRING) {
            query = new WildcardQuery(new Term(queryParam.getField(), "*" + queryParam.getValue() + "*"));
        } else if (queryParam.getDataType() == DataType.TEXT) {
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            String[] queryValues = queryParam.getValue().split(" ");
            Stream.of(queryValues)
                    .map(value -> new Term(queryParam.getField(), value))
                    .map(TermQuery::new)
                    .forEach(q -> builder.add(q, BooleanClause.Occur.SHOULD));
            query = builder.build();
        }
        Preconditions.checkNotNull(query);
        return new BooleanClause(query, BooleanClause.Occur.SHOULD);
    }
}
