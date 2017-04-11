package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.search.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.IMAGE_URL;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.SPECIMEN_ID;

public class FluentSpecimenImageSearchApiBuilder extends FluentSearchApiBuilder<FluentSpecimenImageSearchApiBuilder> {
    public static FluentSpecimenImageSearchApiBuilder aRequest() {
        return new FluentSpecimenImageSearchApiBuilder();
    }
    @Override
    FluentSpecimenImageSearchApiBuilder getThis() {
        return this;
    }

    public FluentSpecimenImageSearchApiBuilder querySpecimenId(SearchField id) {
        buildFieldParameters(SPECIMEN_ID, id);
        return this;
    }

    public FluentSpecimenImageSearchApiBuilder querySpecimenIdForUrl(SearchField id) {
        buildFieldParameters("specimen__specimen_id", id);
        return this;
    }



    public FluentSpecimenImageSearchApiBuilder returnImageUrl(){
        addReturningField(IMAGE_URL);
        return this;
    }
}
