package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

public class FluentSpecimenSearchApiBuilder extends FluentSearchApiBuilder<FluentSpecimenSearchApiBuilder> {
    public static FluentSpecimenSearchApiBuilder aRequest() {
        return new FluentSpecimenSearchApiBuilder();
    }

    @Override
    FluentSpecimenSearchApiBuilder getThis() {
        return this;
    }

    public FluentSpecimenSearchApiBuilder querySpecimenNumber(SearchField specimenNumber) {
        buildMultiSearch(specimenNumber, SPECIMEN_NR, SPECIMEN_ID);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryClassification(SearchField classification) {
        buildMultiSearch(classification, CLASSIFICATION__CLASS_FIELD, CLASSIFICATION__CLASS_EN);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryLocality(SearchField locality) {
        buildMultiSearch(locality, LOCALITY_LOCALITY, LOCALITY_LOCALITY_EN);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryStratigraphy(SearchField stratigraphy) {
        buildMultiSearch(
                stratigraphy,
                STRATIGRAPHY_STRATIGRAPHY,
                STRATIGRAPHY_STRATIGRAPHY_ENG,
                LITHOSTRATIGRAPHY__STRATIGRAPHY,
                LITHOSTRATIGRAPHY__STRATIGRAPHY_ENG,
                STRATIGRAPHY_FREE);
        return this;
    }

    @Override
    public FluentSpecimenSearchApiBuilder queryDepth(SearchField depth) {
        buildMultiSearch(depth, DEPTH, DEPTH_INTERVAL);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryMineralRock(SearchField mineralRock) {
        buildFieldParameters("specimenidentification__name", mineralRock);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryCollectionNumber(SearchField collectionNumber) {
        buildMultiSearch(collectionNumber, COLL__NUMBER, COLL_ID);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryDateAdded(SearchField dateAdded) {
        buildFieldParameters(DATA_ADDED, dateAdded);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryPartOfFossil(SearchField partOfFossil) {
        buildFieldParameters(PART, partOfFossil);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryOriginalStatus(SearchField typeStatus) {
        buildMultiSearch(typeStatus, ORIGINAL_STATUS__VALUE, ORIGINAL_STATUS__VALUE_EN);
        return this;
    }

    public FluentSpecimenSearchApiBuilder queryCollector(SearchField collector) {
        buildMultiSearch(collector, AGENT_COLLECTED, AGENT_COLLECTED__FORENAME, AGENT_COLLECTED__SURENAME);
        return this;
    }
}
