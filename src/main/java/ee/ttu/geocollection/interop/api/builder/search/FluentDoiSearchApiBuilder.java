package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.search.domain.SearchField;

public class FluentDoiSearchApiBuilder extends FluentSearchApiBuilder<FluentDoiSearchApiBuilder> {
    public static FluentDoiSearchApiBuilder aRequest() {
        return new FluentDoiSearchApiBuilder();
    }

    @Override
    FluentDoiSearchApiBuilder getThis() {
        return this;
    }

    public FluentDoiSearchApiBuilder queryTitle(SearchField title) {
        buildFieldParameters("reference__title", title);
        return this;
    }

    public FluentDoiSearchApiBuilder queryIdentifier(SearchField doi) {
        buildFieldParameters("identifier", doi);
        return this;
    }

    public FluentDoiSearchApiBuilder queryAuthor(SearchField author) {
        buildFieldParameters("reference__author", author);
        return this;
    }

    public FluentDoiSearchApiBuilder queryYear(SearchField year) {
        buildFieldParameters("reference__year", year);
        return this;
    }

    public FluentDoiSearchApiBuilder queryPublishedBy(SearchField journal) {
        buildFieldParameters("publisher", journal);
        return this;
    }

    public FluentDoiSearchApiBuilder queryAbstract(SearchField text) {
        buildFieldParameters("abstract", text);
        return this;
    }

}
