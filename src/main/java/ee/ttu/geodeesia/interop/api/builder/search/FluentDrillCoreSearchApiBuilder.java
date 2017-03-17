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
        query += buildFieldParameters(DRILL_CORE, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryBoxNumber(SearchField id) {
        query += buildFieldParameters(BOX_NUMBERS, id);
        return this;
    }

    public FluentDrillCoreSearchApiBuilder queryStorageLocation(SearchField id) {
        query += buildFieldParameters(STORAGE_LOCATION, id);
        return this;
    }
}