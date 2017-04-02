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
        buildMultiSearch(id, DATE_TAKEN, DATE_TAKEN_FREE);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryAuthorAgent(SearchField id) {
        buildMultiSearch(id, AUTHOR_AGENT, AUTHOR_FORENAME, AUTHOR_SURENAME, AUTHOR_FREE);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryKeywords(SearchField keywords) {
        buildMultiSearch(keywords, KEYWORDS, DESCRIPTION, OBJECT, PLACE, LOCALITY_LOCALITY_EN, LOCALITY_LOCALITY);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryNumber(SearchField imageNumber) {
        buildMultiSearch(imageNumber, IMAGE_NUMBER, IMAGESET_NUMBER);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryPeople(SearchField people) {
        buildFieldParameters(PEOPLE, people);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryLocality(SearchField locality) {
        buildMultiSearch(locality, LOCALITY_LOCALITY, LOCALITY_LOCALITY_EN, PLACE);
        return this;
    }

    public FluentPhotoArchiveSearchApiBuilder queryCountry(SearchField adminUnit) {
        buildMultiSearch(
                adminUnit,
                LOCALITY_COUNTRY, LOCALITY_COUNTRY_ENG, LOCALITY__MAAKOND__MAAKOND_EN, LOCALITY__VALD__VALD, LOCALITY__ASUSTUSYKSUS__ASUSTUSYKSUS);
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