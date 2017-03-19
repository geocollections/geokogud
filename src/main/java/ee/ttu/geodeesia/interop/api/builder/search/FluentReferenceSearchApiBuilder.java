package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentReferenceSearchApiBuilder extends FluentSearchApiBuilder<FluentReferenceSearchApiBuilder> {
    public static FluentReferenceSearchApiBuilder aRequest() {
        return new FluentReferenceSearchApiBuilder();
    }

    @Override
    FluentReferenceSearchApiBuilder getThis() {
        return this;
    }

    public FluentReferenceSearchApiBuilder queryTitle(SearchField title) {
        query += buildFieldParameters(TITLE, title);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryDoi(SearchField doi) {
        query += buildFieldParameters(DOI, doi);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryAuthor(SearchField author) {
        query += buildFieldParameters(AUTHOR, author);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryYear(SearchField year) {
        query += buildFieldParameters(YEAR, year);
        return this;
    }

    public FluentReferenceSearchApiBuilder queryBook(SearchField year) {
        query += buildFieldParameters(BOOK, year);
        return this;
    }
    public FluentReferenceSearchApiBuilder queryJournal(SearchField year) {
        query += buildFieldParameters(JOURNAL, year);
        return this;
    }
}
