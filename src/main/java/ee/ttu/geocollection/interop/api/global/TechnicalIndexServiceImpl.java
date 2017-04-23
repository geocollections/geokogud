package ee.ttu.geocollection.interop.api.global;

import com.google.common.base.Preconditions;
import ee.ttu.geocollection.interop.api.global.domain.QueryParam;
import ee.ttu.geocollection.interop.api.global.domain.QueryParameters;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

@Service
public class TechnicalIndexServiceImpl implements TechnicalIndexService {

    @Override
    public void createIndex(Collection<Document> documents, Directory directory) {
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter indexWriter = null;
        try {
            indexWriter = new IndexWriter(directory, config);
            for (Document document : documents) {
                writeIndex(document, indexWriter);
            }
            indexWriter.close();
        } catch (Exception e) {
            if (indexWriter != null) {
                try {
                    indexWriter.close();
                } catch (IOException e1) {
                    throw new RuntimeException(e);
                }
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Document> searchInIndex(QueryParameters queryParameters, Directory directory) {
        Collection<Document> documents = new ArrayList<>();
        try {
            IndexReader indexReader = DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            Query query = buildQuery(queryParameters);

            TopDocs topDocs = indexSearcher.search(query, 10);
            ScoreDoc[] scoreDoc = topDocs.scoreDocs;
            System.out.println(scoreDoc.length);
            for (ScoreDoc score : scoreDoc) {
                Document document = indexReader.document(score.doc);
                documents.add(document);
                System.out.println("DOC " + document);
            }
            //TODO SHOULD I CLOSE IT IN FINALLY BLOCK IN CASE OF EXCEPTION?
            indexReader.close();
        } catch (IOException e) {
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
