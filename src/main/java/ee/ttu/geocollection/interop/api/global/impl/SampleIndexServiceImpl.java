package ee.ttu.geocollection.interop.api.global.impl;

import com.google.common.base.Preconditions;
import ee.ttu.geocollection.domain.LookUpType;
import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.global.DataType;
import ee.ttu.geocollection.interop.api.global.IndexService;
import ee.ttu.geocollection.interop.api.global.QueryParam;
import ee.ttu.geocollection.interop.api.global.QueryParameters;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

@Service
public class SampleIndexServiceImpl implements IndexService {
    private static final String INDEX_DIRECTORY = "kek";
    public static final String ID_STRING = "idString";

    @Autowired
    private Directory sampleDirectory;
    @Autowired
    private SamplesApiService samplesApiService;

    @Override
    public void createIndex() {
        SampleSearchCriteria sampleSearchCriteria = new SampleSearchCriteria();
        sampleSearchCriteria.setId(new SearchField("250", LookUpType.lt));
        sampleSearchCriteria.setSortField(new SortField());

        ApiResponse samples = samplesApiService.findSample(sampleSearchCriteria);

        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        try {
            IndexWriter indexWriter = new IndexWriter(sampleDirectory, config);
            samples.getResult().stream()
                    .map(this::buildDocument)
                    .forEach(document -> writeIndex(document, indexWriter));
            indexWriter.close();

//            IndexReader indexReader = DirectoryReader.open(sampleDirectory);
//            IndexSearcher indexSearcher = new IndexSearcher(indexReader);

            //PhraseQuery - for exact phrase queries
            //Term t = new Term("idString","24");
            //ALSO WORKS:
            //Term t = new Term("locality","sulustvere");
            //Term t2 = new Term("locality", "puurauk");
//            BooleanQuery.Builder builder = new BooleanQuery.Builder();
//            BooleanQuery query = builder.add(new PrefixQuery(t), BooleanClause.Occur.SHOULD).build();

            //works just need to ensure that i transform to lowercase
            Term t = new Term("number", "*\\-14" + "*");//case sensistive!!!!!!!! only finds M-14 but why? standard analyzer uses LowerCaseFilter... probably i will need to do tolowercase for stringfields
            Query query = new WildcardQuery(t);
//            QueryParser queryParser = new QueryParser("number",analyzer);
//            Query query = null;
//            try {
//                query = queryParser.parse("M\\-14*");
//            } catch (ParseException e) {
//                new RuntimeException(e);
//            }
            //WORKS:
            //Term locality = new Term("locality","sulustvere");
            //Query query = new TermQuery(locality);

            //BooleanClause.Occur.
            //Query query = LongPoint.newExactQuery("id", 24L);

//            TopDocs topDocs = indexSearcher.search(query, 10);
//            ScoreDoc[] scoreDoc = topDocs.scoreDocs;
//            System.out.println(scoreDoc.length);
//            for (ScoreDoc score : scoreDoc) {
//                Document document = indexReader.document(score.doc);
//                System.out.println("DOC " + document);
//            }
//
//            indexReader.close();

            String q = "-14";
            Collection<Document> documents = searchInIndex(
                    QueryParameters.params()
                            .appendParameter(ID_STRING, q, DataType.NUMERIC)
                            .appendParameter(NUMBER, q, DataType.STRING)
                            .appendParameter(NUMBER_FIELD, q, DataType.STRING)
                            .appendParameter(LOCALITY_LOCALITY, q, DataType.TEXT));
        } catch (IOException e) {
            //TODO SHOULD CLOES WRITER WHEN EXCEPTION IS THROWN OTHERWISE DIRECTIRY WILL REMAIN LOCKED
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Document> searchInIndex(QueryParameters queryParameters) {
        Collection<Document> documents = new ArrayList<>();
        try {
            IndexReader indexReader = DirectoryReader.open(sampleDirectory);
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

    @Override
    public Document buildDocument(Map<String, Object> entry) {
        Document document = new Document();
        Long idLong = Long.valueOf(entry.get(ID).toString());

        LongPoint id = new LongPoint(ID, idLong);
        document.add(id);

        Object dateChanged = entry.get(DATE_CHANGED);
        if (dateChanged != null) {
            StoredField dateChangedStored = new StoredField(DATE_CHANGED, dateChanged.toString());
            document.add(dateChangedStored);
        }

        //i am forced to use here stringfield because there might be special characters in the number: M-14 and textfield cannot handle them
        StringField number = new StringField(NUMBER, ((String) entry.get(NUMBER)).toLowerCase(), Field.Store.NO);
        document.add(number);

        String numberAdditional = (String) entry.get(NUMBER_ADDITIONAL);
        if (numberAdditional != null) {
            StringField numberAdditionalField = new StringField(NUMBER_ADDITIONAL, numberAdditional.toLowerCase(), Field.Store.NO);
            document.add(numberAdditionalField);
        }

        String locality = (String) entry.get(LOCALITY_LOCALITY);
        if (locality != null) {
            TextField localityField = new TextField(LOCALITY_LOCALITY, locality, Field.Store.NO);
            document.add(localityField);
        }

        StringField idField = new StringField(ID_STRING, idLong.toString(), Field.Store.YES);
        document.add(idField);
        return document;
    }
}
