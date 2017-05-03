package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.taxon.TaxonApiService;
import ee.ttu.geocollection.interop.api.taxon.TaxonSearchCriteria;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

import static ee.ttu.geocollection.indexing.GlobalSearchConstants.ID_LONG;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;
import static java.util.stream.Collectors.toList;

@Service
public class TaxonIndexServiceImpl extends AbstractIndexingService<TaxonSearchCriteria> {

    @Autowired
    private DirectoryReader taxonDirectoryReader;
    @Autowired
    private IndexWriter taxonDirectoryWriter;
    @Autowired
    private TechnicalIndexService technicalIndexService;
    @Autowired
    private TaxonApiService taxonApiService;

    @Override
    protected void updateIndex() {
        TaxonSearchCriteria updateSearchCriteria = new TaxonSearchCriteria();
        updateSearchCriteria.setSortField(new SortField(DATE_CHANGED, SortingOrder.DESCENDING));
        updateOldIndices(
                updateSearchCriteria,
                (searchCriteria) -> taxonApiService.findTaxonForIndex(searchCriteria),
                taxonDirectoryWriter,
                taxonDirectoryReader,
                technicalIndexService);
    }

    @Override
    protected void createIndex() {
        TaxonSearchCriteria createSearchCriteria = new TaxonSearchCriteria();
        createSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createMissingIndices(
                createSearchCriteria,
                (searchCriteria) -> taxonApiService.findTaxonForIndex(searchCriteria),
                taxonDirectoryWriter,
                taxonDirectoryReader,
                technicalIndexService);
    }

    @Override
    protected Document buildDocument(Map<String, Object> entry) {
        Long idLong = Long.valueOf(entry.get(ID).toString());

        Document document = DocumentBuilder.aDocument()
                .targetEntry(entry)
                .withField(ID, StringField.TYPE_STORED)
                .withField(TAXON, StringField.TYPE_NOT_STORED)
                .withField(PARENT_TAXON, StringField.TYPE_NOT_STORED)
                .withField(FOSSIL_GROUP_TAXON, StringField.TYPE_NOT_STORED)
                .withField(DATE_CHANGED, StringField.TYPE_STORED)
                .build();
        document.add(new LongPoint(ID_LONG, idLong));

        return document;
    }

    @Override
    public ApiResponse searchInIndex(String value) {
        Collection<Document> documents = technicalIndexService.searchInIndex(
                QueryParameters.params()
                        .queryValue(value)
                        .appendParameter(ID, DataType.NUMERIC)
                        .appendParameter(TAXON, DataType.STRING)
                        .appendParameter(PARENT_TAXON, DataType.STRING)
                        .appendParameter(FOSSIL_GROUP_TAXON, DataType.STRING),
                taxonDirectoryReader);
        return documents.isEmpty() ?
                new ApiResponse() :
                taxonApiService.findTaxonsByIds(
                        documents.stream()
                                .map(document -> document.get(ID))
                                .collect(toList()));
    }
}
