package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.domain.SortingOrder;
import ee.ttu.geocollection.indexing.AbstractIndexingService;
import ee.ttu.geocollection.indexing.domain.DataType;
import ee.ttu.geocollection.indexing.domain.DocumentBuilder;
import ee.ttu.geocollection.indexing.domain.QueryParameters;
import ee.ttu.geocollection.indexing.technical.TechnicalIndexService;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.reference.pojo.ReferenceSearchCriteria;
import ee.ttu.geocollection.interop.api.reference.service.ReferenceApiService;
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
public class ReferenceIndexServiceImpl extends AbstractIndexingService<ReferenceSearchCriteria> {

    @Autowired
    private DirectoryReader referenceDirectoryReader;
    @Autowired
    private IndexWriter referenceDirectoryWriter;
    @Autowired
    private TechnicalIndexService technicalIndexService;
    @Autowired
    private ReferenceApiService referenceApiService;

    @Override
    protected void updateIndex() {
        ReferenceSearchCriteria updateSearchCriteria = new ReferenceSearchCriteria();
        updateSearchCriteria.setSortField(new SortField(DATE_CHANGED, SortingOrder.DESCENDING));
        updateOldIndices(
                updateSearchCriteria,
                (searchCriteria) -> referenceApiService.findReferencesForIndex(searchCriteria),
                referenceDirectoryWriter,
                referenceDirectoryReader,
                technicalIndexService);
    }

    @Override
    protected void createIndex() {
        ReferenceSearchCriteria createSearchCriteria = new ReferenceSearchCriteria();
        createSearchCriteria.setSortField(new SortField(ID, SortingOrder.DESCENDING));
        createMissingIndices(
                createSearchCriteria,
                (searchCriteria) -> referenceApiService.findReferencesForIndex(searchCriteria),
                referenceDirectoryWriter,
                referenceDirectoryReader,
                technicalIndexService);
    }

    @Override
    protected Document buildDocument(Map<String, Object> entry) {
        Long idLong = Long.valueOf(entry.get(ID).toString());

        Document document = DocumentBuilder.aDocument()
                .targetEntry(entry)
                .withField(ID, StringField.TYPE_STORED)
                .withField(YEAR, StringField.TYPE_NOT_STORED)
                .withField(AUTHOR, StringField.TYPE_NOT_STORED)
                .withField(TITLE, StringField.TYPE_NOT_STORED)
                .withField(REFERENCE, StringField.TYPE_NOT_STORED)
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
                        .appendParameter(YEAR, DataType.NUMERIC)
                        .appendParameter(AUTHOR, DataType.STRING)
                        .appendParameter(TITLE, DataType.STRING)
                        .appendParameter(REFERENCE, DataType.STRING),
                referenceDirectoryReader);
        return documents.isEmpty() ?
                new ApiResponse() :
                referenceApiService.findImagesByIds(
                        documents.stream()
                                .map(document -> document.get(ID))
                                .collect(toList()));
    }
}
