package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

public class FluentLocalitySearchApiBuilder extends FluentSearchApiBuilder<FluentLocalitySearchApiBuilder> {

    public static FluentLocalitySearchApiBuilder aRequest() {
        return new FluentLocalitySearchApiBuilder();
    }

    @Override
    FluentLocalitySearchApiBuilder getThis() {
        return this;
    }

    public FluentLocalitySearchApiBuilder queryNumber(SearchField id) {
        buildFieldParameters(NUMBER, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryStratigraphy(SearchField id) {
        buildFieldParameters(LOCALITY_STRATIGRAPHY, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryMaId(SearchField id) {
        buildFieldParameters(MA_ID, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryLocality(SearchField locality) {
        buildMultiSearch(locality, LOCALITY_ENG, LOCALITY);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryCountry(SearchField id) {
        buildFieldParameters(COUNTRY, id);
        return this;
    }
    public FluentLocalitySearchApiBuilder queryAdminUnit(SearchField id) {
        buildFieldParameters(ADMIN_UNIT, id);
        return this;
    }
    public FluentLocalitySearchApiBuilder queryLatitude(SearchField id) {
        buildFieldParameters(LATITUDE, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryLongitude(SearchField id) {
        buildFieldParameters(LONGITUDE, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder queryVerticalExtend(SearchField id) {
        buildFieldParameters(LONGITUDE, id);
        return this;
    }

    public FluentLocalitySearchApiBuilder returnLocalitySynonym() {
        addReturningField(LOCALITYSYNONYM_SYNONYM);
        return this;
    }
    public FluentLocalitySearchApiBuilder returnLocalityTopEn() {
        addReturningField(LOCALITY_STRATIGRAPHY_TOP_EN);
        return this;
    }
    public FluentLocalitySearchApiBuilder returnLocalityTop() {
        addReturningField(LOCALITY_STRATIGRAPHY_TOP);
        return this;
    }
    public FluentLocalitySearchApiBuilder returnLocalityBaseEn() {
        addReturningField(LOCALITY_STRATIGRAPHY_BASE_EN);
        return this;
    }
    public FluentLocalitySearchApiBuilder returnLocalityBase() {
        addReturningField(LOCALITY_STRATIGRAPHY_BASE);
        return this;
    }
}
