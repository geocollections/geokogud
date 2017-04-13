package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

public class FluentReferenceSearchApiBuilder extends FluentSearchApiBuilder<FluentReferenceSearchApiBuilder> {
    public static FluentReferenceSearchApiBuilder aRequest() {
        return new FluentReferenceSearchApiBuilder();
    }

    @Override
    FluentReferenceSearchApiBuilder getThis() {
        return this;
    }

    public FluentReferenceSearchApiBuilder queryTitle(SearchField title) {
        buildFieldParameters(TITLE, title);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryDoi(SearchField doi) {
        buildFieldParameters(DOI, doi);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryAuthor(SearchField author) {
        buildFieldParameters(AUTHOR, author);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryYear(SearchField year) {
        buildFieldParameters(YEAR, year);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryBook(SearchField book) {
        buildFieldParameters(BOOK, book);
        return this;
    }
    public FluentReferenceSearchApiBuilder queryJournal(SearchField journal) {
        buildFieldParameters(JOURNAL, journal);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryAbstract(SearchField text) {
        buildFieldParameters(ABSTRACT, text);
        return this;
    }
}
