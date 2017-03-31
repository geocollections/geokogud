package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentPhotoArchiveSearchApiBuilder extends FluentSearchApiBuilder<FluentPhotoArchiveSearchApiBuilder>{

    public static FluentPhotoArchiveSearchApiBuilder aRequest() {
        return new FluentPhotoArchiveSearchApiBuilder();
    }

    @Override
    FluentPhotoArchiveSearchApiBuilder getThis() {
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryFileName(SearchField id) {
        buildFieldParameters(FILE_NAME, id);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryDateTaken(SearchField id) {
        buildFieldParameters(DATE_TAKEN, id);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryAuthorAgent(SearchField id) {
        buildFieldParameters(AUTHOR_AGENT, id);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryKeywords(SearchField keywords) {
        buildFieldParameters(KEYWORDS, keywords);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryNumber(SearchField imageNumber) {
        buildFieldParameters(IMAGE_NUMBER, imageNumber);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryPeople(SearchField people) {
        buildFieldParameters(PEOPLE, people);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryLocality(SearchField locality) {
        buildFieldParameters(LOCALITY_LOCALITY, locality);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryCountry(SearchField adminUnit) {
        buildFieldParameters(LOCALITY_COUNTRY, adminUnit);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder querySizeX(SearchField sizeX) {
        buildFieldParameters(SIZE_X, sizeX);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder querySizeY(SearchField sizeY) {
        buildFieldParameters(SIZE_Y, sizeY);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder returnObject() {
        addReturningField(OBJECT);
        return this;
    }
}