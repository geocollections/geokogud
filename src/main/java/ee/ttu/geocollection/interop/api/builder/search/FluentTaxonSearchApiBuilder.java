package ee.ttu.geocollection.interop.api.builder.search;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

public class FluentTaxonSearchApiBuilder extends FluentSearchApiBuilder<FluentTaxonSearchApiBuilder>{

    public static FluentTaxonSearchApiBuilder aRequest() {
        return new FluentTaxonSearchApiBuilder();
    }

    @Override
    FluentTaxonSearchApiBuilder getThis() {
        return this;
    }

    public FluentTaxonSearchApiBuilder returnTaxon() {
        addReturningField(TAXON);
        return this;
    }

    public FluentTaxonSearchApiBuilder returnParentTaxon() {
        addReturningField(PARENT_TAXON);
        return this;
    }

    public FluentTaxonSearchApiBuilder returnFossilGroupTaxon() {
        addReturningField(FOSSIL_GROUP_TAXON);
        return this;
    }

    public FluentTaxonSearchApiBuilder returnAuthorYear() {
        addReturningField(AUTHOR_YEAR);
        return this;
    }

}
