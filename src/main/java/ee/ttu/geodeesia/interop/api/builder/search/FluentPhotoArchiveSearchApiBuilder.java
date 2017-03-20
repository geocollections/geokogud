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

    public FluentPhotoArchiveSearchApiBuilder queryKeywords(SearchField keywords) {
        query += buildFieldParameters(KEYWORDS, keywords);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryNumber(SearchField imageNumber) {
        query += buildFieldParameters(IMAGE_NUMBER, imageNumber);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryPeople(SearchField people) {
        query += buildFieldParameters(PEOPLE, people);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryLocality(SearchField locality) {
        query += buildFieldParameters(LOCALITY_LOCALITY, locality);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryCountry(SearchField adminUnit) {
        query += buildFieldParameters(LOCALITY_COUNTRY, adminUnit);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder querySizeX(SearchField sizeX) {
        query += buildFieldParameters(SIZE_X, sizeX);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder querySizeY(SearchField sizeY) {
        query += buildFieldParameters(SIZE_Y, sizeY);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder returnObject() {
        addReturningField(OBJECT);
        return this;
    }
}