package ee.ttu.geocollection;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.IOException;

@Configuration
public class IndexConfig {

    @Bean
    public Directory sampleDirectory() {
        return new RAMDirectory();
    }

    @Bean
    public IndexWriter sampleDirectoryWriter(Directory sampleDirectory) {
        return createWriter(sampleDirectory);
    }

    @Bean
    @DependsOn("sampleDirectoryWriter")
    public DirectoryReader sampleDirectoryReader(Directory sampleDirectory) {
        return openReader(sampleDirectory);
    }

    @Bean
    public Directory specimenDirectory() {
        return new RAMDirectory();
    }

    @Bean
    public IndexWriter specimenDirectoryWriter(Directory specimenDirectory) {
        return createWriter(specimenDirectory);
    }

    @Bean
    @DependsOn("specimenDirectoryWriter")
    public DirectoryReader specimenDirectoryReader(Directory specimenDirectory) {
        return openReader(specimenDirectory);
    }

    @Bean
    public Directory localityDirectory() {
        return new RAMDirectory();
    }

    @Bean
    public IndexWriter localityDirectoryWriter(Directory localityDirectory) {
        return createWriter(localityDirectory);
    }

    @Bean
    @DependsOn("localityDirectoryWriter")
    public DirectoryReader localityDirectoryReader(Directory localityDirectory) {
        return openReader(localityDirectory);
    }

    @Bean
    public Directory imageDirectory() {
        return new RAMDirectory();
    }

    @Bean
    public IndexWriter imageDirectoryWriter(Directory imageDirectory) {
        return createWriter(imageDirectory);
    }

    @Bean
    @DependsOn("imageDirectoryWriter")
    public DirectoryReader imageDirectoryReader(Directory imageDirectory) {
        return openReader(imageDirectory);
    }

    @Bean
    public Directory taxonDirectory() {
        return new RAMDirectory();
    }

    @Bean
    public IndexWriter taxonDirectoryWriter(Directory taxonDirectory) {
        return createWriter(taxonDirectory);
    }

    @Bean
    @DependsOn("imageDirectoryWriter")
    public DirectoryReader taxonDirectoryReader(Directory taxonDirectory) {
        return openReader(taxonDirectory);
    }

    @Bean
    public Directory referenceDirectory() {
        return new RAMDirectory();
    }

    @Bean
    public IndexWriter referenceDirectoryWriter(Directory referenceDirectory) {
        return createWriter(referenceDirectory);
    }

    @Bean
    @DependsOn("referenceDirectoryWriter")
    public DirectoryReader referenceDirectoryReader(Directory referenceDirectory) {
        return openReader(referenceDirectory);
    }

    @Bean
    public Directory stratigraphyDirectory() {
        return new RAMDirectory();
    }

    @Bean
    public IndexWriter stratigraphyDirectoryWriter(Directory stratigraphyDirectory) {
        return createWriter(stratigraphyDirectory);
    }

    @Bean
    @DependsOn("stratigraphyDirectoryWriter")
    public DirectoryReader stratigraphyDirectoryReader(Directory stratigraphyDirectory) {
        return openReader(stratigraphyDirectory);
    }

    private IndexWriter createWriter(Directory directory) {
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter indexWriter = null;
        try {
            indexWriter = new IndexWriter(directory, config);
            indexWriter.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return indexWriter;
    }

    private DirectoryReader openReader(Directory directory) {
        try {
            return DirectoryReader.open(directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}