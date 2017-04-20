package ee.ttu.geocollection.interop.api.builder.search;

import ee.ttu.geocollection.domain.SearchField;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.IMAGE_URL;
import static ee.ttu.geocollection.interop.api.builder.ApiFields.SPECIMEN_ID;

public class FluentDrillCoreImageSearchApiBuilder extends FluentSearchApiBuilder<FluentDrillCoreImageSearchApiBuilder> {
    public static FluentDrillCoreImageSearchApiBuilder aRequest() {
        return new FluentDrillCoreImageSearchApiBuilder();
    }
    @Override
    FluentDrillCoreImageSearchApiBuilder getThis() {
        return this;
    }

    public FluentDrillCoreImageSearchApiBuilder querySpecimenIdForUrl(SearchField id) {
        buildFieldParameters("drillcore_box__drillcore", id);
        return this;
    }

    public FluentDrillCoreImageSearchApiBuilder returnImageUrl(){
        addReturningField("drillcoreimage__url");
        return this;
    }
}
