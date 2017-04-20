package ee.ttu.geocollection.interop.api.builder.search;

import com.google.common.collect.Lists;
import ee.ttu.geocollection.domain.LookUpType;
import ee.ttu.geocollection.domain.SearchField;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FluentSearchApiBuilderTest {
    @Spy
    FluentSearchApiBuilder builder;

    @Before
    public void setup() {
        when(builder.getThis()).thenReturn(builder);
    }

    @Test
    public void shouldQueryById() {
        builder.queryId(new SearchField("100", LookUpType.exact));

        String query = builder.buildDefaultFieldsQuery();

        assertThat(query).isEqualTo("&id__exact=100");
    }

    @Test
    public void shouldQueryByInstitutions() {
        List<String> institutions = Lists.newArrayList("GIT", "TUG", "ELM");
        builder.queryInstitutions(institutions);

        String query = builder.buildDefaultFieldsQuery();

        assertThat(query).isEqualTo("&or_search=database__acronym__exact:GIT;database__acronym__exact:TUG;database__acronym__exact:ELM");
    }

    @Test
    public void shouldQueryByDepth() {
        builder.queryDepth(new SearchField("30", LookUpType.gt));

        String query = builder.buildDefaultFieldsQuery();

        assertThat(query).isEqualTo("&depth__gt=30");
    }

    @Test
    public void shouldQueryNotNullId() {
        builder.fieldIsNotNull("id");

        String query = builder.buildDefaultFieldsQuery();

        assertThat(query).isEqualTo("&id__isnull=false");
    }

    @Test
    public void shouldBuildMultiSearch() {
        builder.buildMultiSearch(new SearchField("155-57", LookUpType.exact), "coll__number", "specimen_id");

        String query = builder.buildDefaultFieldsQuery();

        assertThat(query).isEqualTo("&multi_search=value:155-57;fields:coll__number,specimen_id;lookuptype:exact");
    }

    @Test
    public void shouldAddReturningField() {
        builder.addReturningField("depth");

        String query = builder.buildFullQuery();

        assertThat(query).isEqualTo("&fields=depth");
    }

    @Test
    public void shouldQueryAndReturnField() {
        builder.queryId(new SearchField("100", LookUpType.exact))
                .andReturn();

        String query = builder.buildFullQuery();

        assertThat(query).isEqualTo("&id__exact=100&fields=id");
    }

    @Test
    public void shouldQueryAndReturnMultipleFields() {
        builder.queryId(new SearchField("200", LookUpType.gte)).andReturn()
                .queryDepth(new SearchField("10", LookUpType.exact)).andReturn();

        String query = builder.buildFullQuery();

        assertThat(query).isEqualTo("&id__gte=200&depth__exact=10&fields=id,depth");
    }
}