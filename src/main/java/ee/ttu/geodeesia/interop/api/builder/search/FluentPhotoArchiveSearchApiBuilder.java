package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.AUTHOR_AGENT;
import static ee.ttu.geodeesia.interop.api.builder.ApiFields.DATE_TAKEN;
import static ee.ttu.geodeesia.interop.api.builder.ApiFields.FILE_NAME;

public class FluentPhotoArchiveSearchApiBuilder extends FluentSearchApiBuilder<FluentPhotoArchiveSearchApiBuilder>{

    public static FluentPhotoArchiveSearchApiBuilder aRequest() {
        return new FluentPhotoArchiveSearchApiBuilder();
    }

    @Override
    FluentPhotoArchiveSearchApiBuilder getThis() {
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryFileName(SearchField id) {
        query += buildFieldParameters(FILE_NAME, id);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryDateTaken(SearchField id) {
        query += buildFieldParameters(DATE_TAKEN, id);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryAuthorAgent(SearchField id) {
        query += buildFieldParameters(AUTHOR_AGENT, id);
        return this;
    }
}