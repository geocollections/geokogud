package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

public class FluentDoiSearchApiBuilder extends FluentSearchApiBuilder<FluentDoiSearchApiBuilder> {
    public static FluentDoiSearchApiBuilder aRequest() {
        return new FluentDoiSearchApiBuilder();
    }

    @Override
    FluentDoiSearchApiBuilder getThis() {
        return this;
    }

    public FluentDoiSearchApiBuilder queryTitle(SearchField title) {
        query += buildFieldParameters("reference__title", title);
        return this;
    }

    public FluentDoiSearchApiBuilder queryIdentifier(SearchField doi) {
        query += buildFieldParameters("identifier", doi);
        return this;
    }

    public FluentDoiSearchApiBuilder queryAuthor(SearchField author) {
        query += buildFieldParameters("reference__author", author);
        return this;
    }

    public FluentDoiSearchApiBuilder queryYear(SearchField year) {
        query += buildFieldParameters("reference__year", year);
        return this;
    }

    public FluentDoiSearchApiBuilder queryPublishedBy(SearchField journal) {
        query += buildFieldParameters("publisher", journal);
        return this;
    }

    public FluentDoiSearchApiBuilder queryAbstract(SearchField text) {
        query += buildFieldParameters("abstract", text);
        return this;
    }

}
