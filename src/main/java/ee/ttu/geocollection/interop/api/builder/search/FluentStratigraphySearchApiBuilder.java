package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.search.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

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
        buildMultiSearch(stratigraphy, STRATIGRAPHY, STRATIGRAPHY_EN);
        return this;
    }

    public FluentStratigraphySearchApiBuilder queryIndex(SearchField index){
        buildMultiSearch(index, INDEX_MAIN, INDEX_ADDITIONAL);
        return this;
    }

    public FluentStratigraphySearchApiBuilder queryAgeBase(SearchField ageBase) {
        buildFieldParameters(AGE_BASE, ageBase);
        return this;
    }

    public FluentStratigraphySearchApiBuilder queryLithology(SearchField lithology) {
        buildMultiSearch(lithology, LITHOLOGY, LITHOLOGY_EN);
        return this;
    }

    public FluentStratigraphySearchApiBuilder queryAuthor(SearchField author) {
        buildFieldParameters(AUTHOR_FREE, author);
        return this;
    }
}
