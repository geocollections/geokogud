package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

public class FluentDoiSearchApiBuilder extends FluentSearchApiBuilder<FluentDoiSearchApiBuilder> {
    public static FluentDoiSearchApiBuilder aRequest() {
        return new FluentDoiSearchApiBuilder();
    }

    @Override
    FluentDoiSearchApiBuilder getThis() {
        return this;
    }

    public FluentDoiSearchApiBuilder queryIdentifier(SearchField doi) {
        buildFieldParameters(IDENTIFIER, doi);
        return this;
    }

    public FluentDoiSearchApiBuilder queryTitle(SearchField title) {
        buildFieldParameters(REFERENCETITLE, title);
        return this;
    }

    public FluentDoiSearchApiBuilder queryPublishedBy(SearchField journal) {
        buildFieldParameters(PUBLISHER, journal);
        return this;
    }

    public FluentDoiSearchApiBuilder queryYear(SearchField year) {
        buildFieldParameters(REFERENCEYEAR, year);
        return this;
    }

    public FluentDoiSearchApiBuilder queryAuthor(SearchField author) {
        buildFieldParameters(REFERENCEAUTHOR, author);
        return this;
    }

    public FluentDoiSearchApiBuilder queryAbstract(SearchField abstractText) {
        buildFieldParameters(ABSTRACT, abstractText);
        return this;
    }

}
