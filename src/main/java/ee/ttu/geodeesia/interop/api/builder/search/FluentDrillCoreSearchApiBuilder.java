package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentDrillCoreSearchApiBuilder extends FluentSearchApiBuilder<FluentDrillCoreSearchApiBuilder>{

    public static FluentDrillCoreSearchApiBuilder aRequest() {
        return new FluentDrillCoreSearchApiBuilder();
    }

    @Override
    FluentDrillCoreSearchApiBuilder getThis() {
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryDrillCore(SearchField id) {
        buildFieldParameters(DRILL_CORE, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryBoxNumber(SearchField id) {
        buildFieldParameters(BOX_NUMBERS, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryStorageLocation(SearchField id) {
        buildFieldParameters(STORAGE_LOCATION, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryLocalityCountry(SearchField id) {
        buildFieldParameters(LOCALITY_COUNTRY, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryLocalityCountryEng (SearchField id) {
        buildFieldParameters(LOCALITY_COUNTRY_ENG, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryLocalityLongitude (SearchField id) {
        buildFieldParameters(LOCALITY_LONGITUDE, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryLocalityLatitude (SearchField id) {
        buildFieldParameters(LOCALITY_LATITUDE, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryDepth (SearchField id) {
        buildFieldParameters(DEPTH, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryBoxes (SearchField id) {
        buildFieldParameters(BOXES, id);
        return this;
    }
}
