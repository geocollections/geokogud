package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.IMAGE_URL;

public class FluentLocalityImageSearchApiBuilder extends FluentSearchApiBuilder<FluentLocalityImageSearchApiBuilder> {
    public static FluentLocalityImageSearchApiBuilder aRequest() {
        return new FluentLocalityImageSearchApiBuilder();
    }
    @Override
    FluentLocalityImageSearchApiBuilder getThis() {
        return this;
    }

    public FluentLocalityImageSearchApiBuilder queryLocalityIdForUrl(SearchField id) {
        buildFieldParameters("locality_id", id);
        return this;
    }

    public FluentLocalityImageSearchApiBuilder returnImageUrl(){
        addReturningField(IMAGE_URL);
        return this;
    }
}
