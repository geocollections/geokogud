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
        buildFieldParameters("specimen_nr", specimenNumber);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryClassification(SearchField classification) {
        buildFieldParameters("classification__class_field", classification);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryLocality(SearchField locality) {
        buildFieldParameters("locality__locality", locality);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryStratigraphy(SearchField stratigraphy) {
        buildFieldParameters("stratigraphy__stratigraphy", stratigraphy);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryMineralRock(SearchField mineralRock) {
        buildFieldParameters("specimenidentification__name", mineralRock);
        return this;
    }
}
