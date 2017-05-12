package ee.ttu.geocollection.interop.api.taxon.impl;

import ee.ttu.geocollection.domain.SortField;
import ee.ttu.geocollection.indexing.IndexingProperties;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.search.FluentTaxonSearchApiBuilder;
import ee.ttu.geocollection.interop.api.service.ApiService;
import ee.ttu.geocollection.interop.api.taxon.TaxonApiService;
import ee.ttu.geocollection.interop.api.taxon.TaxonSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaxonApiServiceImpl implements TaxonApiService {

    public static final String TAXON_TABLE = "taxon";
    @Autowired
    private IndexingProperties indexingProperties;
    @Autowired
    private ApiService apiService;

    @Override
    public ApiResponse findTaxonForIndex(TaxonSearchCriteria searchCriteria) {
        String requestParams = FluentTaxonSearchApiBuilder.aRequest()
                .returnId()
                .returnTaxon()
                .returnParentTaxon()
                .returnFossilGroupTaxon()
                .buildFullQuery();
        return apiService.searchRawEntities(
                TAXON_TABLE, indexingProperties.getIndexingBatchSize(), searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public ApiResponse findTaxonsByIds(List<String> ids) {
        String requestParams = FluentTaxonSearchApiBuilder.aRequest()
                .queryMultipleIds(ids).andReturn()
                .returnTaxon()
                .returnParentTaxon()
                .returnFossilGroupTaxon()
                .returnAuthorYear()
                .buildFullQuery();
        return apiService.searchRawEntities(TAXON_TABLE, ids.size() + 1, 1, new SortField(), requestParams);
    }
}