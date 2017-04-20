package ee.ttu.geocollection.interop.api.global;

import ee.ttu.geocollection.domain.LookUpType;
import ee.ttu.geocollection.domain.SearchField;
import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.samples.pojo.SampleSearchCriteria;
import ee.ttu.geocollection.interop.api.samples.service.SamplesApiService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class IndexService {
    private static final String INDEX_DIRECTORY = "kek";

    @Autowired
    private Directory sampleDirectory;
    @Autowired
    private SamplesApiService samplesApiService;

    public void indexSamples() {
        SampleSearchCriteria sampleSearchCriteria = new SampleSearchCriteria();
        sampleSearchCriteria.setId(new SearchField("200", LookUpType.gt));
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

            IndexReader indexReader = DirectoryReader.open(sampleDirectory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);

//            Term t = new Term("id","24");
//            Query query = new TermQuery(t);
            Query query = LongPoint.newExactQuery("id", 24L);
            TopDocs topDocs = indexSearcher.search(query, 10);
            ScoreDoc[] scoreDoc = topDocs.scoreDocs;
            System.out.println(scoreDoc.length);
            for (ScoreDoc score : scoreDoc) {
                Document document = indexReader.document(score.doc);
                System.out.println("DOC " + document);
            }

            indexReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeIndex(Document document, IndexWriter indexWriter) {
        try {
            indexWriter.addDocument(document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Document buildDocument(Map<String, Object> entry) {
        Document document = new Document();
        Long idLong = Long.valueOf(entry.get("id").toString());
        LongPoint id = new LongPoint("id", idLong);
        StoredField idOriginal = new StoredField("idOriginal", idLong);
        TextField number = new TextField("number", (String) entry.get("number"), Field.Store.NO);
        TextField numberAdditional = new TextField("number_additional", (String) entry.get("number"), Field.Store.NO);
        document.add(id);
        document.add(idOriginal);
        document.add(number);
        document.add(numberAdditional);
        return document;
    }
}
