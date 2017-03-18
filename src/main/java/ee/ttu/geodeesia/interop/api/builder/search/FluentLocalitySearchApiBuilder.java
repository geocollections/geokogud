package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentLocalitySearchApiBuilder extends FluentSearchApiBuilder<FluentLocalitySearchApiBuilder> {

    public static FluentLocalitySearchApiBuilder aRequest() {
        return new FluentLocalitySearchApiBuilder();
    }

    @Override
    FluentLocalitySearchApiBuilder getThis() {
        return this;
    }

    public FluentLocalitySearchApiBuilder queryNumber(SearchField id) {
        query += buildFieldParameters(NUMBER, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryStratigraphy(SearchField id) {
        query += buildFieldParameters(LOCALITY_STRATIGRAPHY, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryReference(SearchField id) {
        query += buildFieldParameters(REFERENCE, id);
        return this;
    }
    public FluentLocalitySearchApiBuilder queryMaId(SearchField id) {
        query += buildFieldParameters(MA_ID, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryLocality(SearchField id) {
        query += buildFieldParameters(LOCALITY, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryCountry(SearchField id) {
        query += buildFieldParameters(COUNTRY, id);
        return this;
    }
    public FluentLocalitySearchApiBuilder queryAdminUnit(SearchField id) {
        query += buildFieldParameters(ADMIN_UNIT, id);
        return this;
    }
    public FluentLocalitySearchApiBuilder queryLatitude(SearchField id) {
        query += buildFieldParameters(LATITUDE, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryLongitude(SearchField id) {
        query += buildFieldParameters(LONGITUDE, id);
        return this;
    }
}
