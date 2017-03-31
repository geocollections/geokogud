package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentStratigraphySearchApiBuilder extends FluentSearchApiBuilder<FluentStratigraphySearchApiBuilder>{

    public static FluentStratigraphySearchApiBuilder aRequest() {
        return new FluentStratigraphySearchApiBuilder();
    }

    @Override
    FluentStratigraphySearchApiBuilder getThis() {
        return this;
    }

    public FluentStratigraphySearchApiBuilder queryId(SearchField id) {
        buildFieldParameters(ID, id);
        return this;
    }

    public FluentStratigraphySearchApiBuilder queryStratigraphy(SearchField stratigraphy){
        buildFieldParameters(STRATIGRAPHY, stratigraphy);
        return this;
    }

    public FluentStratigraphySearchApiBuilder queryIndex(SearchField index){
        buildFieldParameters(INDEX_MAIN, index);
        return this;
    }
}
