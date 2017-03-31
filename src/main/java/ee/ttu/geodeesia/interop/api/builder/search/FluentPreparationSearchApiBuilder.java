package ee.ttu.geodeesia.interop.api.builder.search;

import ee.ttu.geodeesia.search.domain.SearchField;

public class FluentPreparationSearchApiBuilder extends FluentSearchApiBuilder<FluentPreparationSearchApiBuilder> {
    public static FluentPreparationSearchApiBuilder aRequest() {
        return new FluentPreparationSearchApiBuilder();
    }

    @Override
    FluentPreparationSearchApiBuilder getThis() {
        return this;
    }

    public FluentPreparationSearchApiBuilder queryNumber(SearchField text) {
        buildFieldParameters("preparation_number", text);
        return this;
    }
    public FluentPreparationSearchApiBuilder queryLocality(SearchField text) {
        buildFieldParameters("sample__locality__locality", text);
        return this;
    }
    public FluentPreparationSearchApiBuilder queryLocalityEn(SearchField text) {
        buildFieldParameters("sample__locality__locality_en", text);
        return this;
    }
    public FluentPreparationSearchApiBuilder queryDepth(SearchField text) {
        buildFieldParameters("sample__depth_interval", text);
        return this;
    }

    public FluentPreparationSearchApiBuilder queryStratigraphy(SearchField text) {
        buildFieldParameters("sample__stratigraphy__stratigraphy", text);
        return this;
    }

    public FluentPreparationSearchApiBuilder queryStratigraphyEn(SearchField text) {
        buildFieldParameters("sample__stratigraphy__stratigraphy_en", text);
        return this;
    }

    public FluentPreparationSearchApiBuilder queryCollector(SearchField text) {
        buildFieldParameters("sample__agent_collected__agent", text);
        return this;
    }

}
