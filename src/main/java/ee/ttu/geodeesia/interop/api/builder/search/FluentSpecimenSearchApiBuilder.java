package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

public class FluentSpecimenSearchApiBuilder extends FluentSearchApiBuilder<FluentSpecimenSearchApiBuilder> {
    public static FluentSpecimenSearchApiBuilder aRequest() {
        return new FluentSpecimenSearchApiBuilder();
    }

    @Override
    FluentSpecimenSearchApiBuilder getThis() {
        return this;
    }

    public FluentSpecimenSearchApiBuilder querySpecimenNumber(SearchField specimenNumber) {
        query += buildFieldParameters("specimen_nr", specimenNumber);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryClassification(SearchField classification) {
        query += buildFieldParameters("classification__class_field", classification);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryLocality(SearchField locality) {
        query += buildFieldParameters("locality__locality", locality);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryStratigraphy(SearchField stratigraphy) {
        query += buildFieldParameters("stratigraphy__stratigraphy", stratigraphy);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryMineralRock(SearchField mineralRock) {
        query += buildFieldParameters("specimenidentification__name", mineralRock);
        return this;
    }
}
