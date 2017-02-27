package ee.ttu.geodeesia.interop.api.taxon.service;

import ee.ttu.geodeesia.interop.api.Request.SearchApiRequest;
import ee.ttu.geodeesia.interop.api.taxon.pojo.TaxonApiResponse;

public interface TaxonApiService {
    TaxonApiResponse searchTaxon(String q);

    TaxonApiResponse searchTaxon(String q, SearchApiRequest request);

    TaxonApiResponse searchTaxonList();

    TaxonApiResponse searchTaxonList(SearchApiRequest request);
}
