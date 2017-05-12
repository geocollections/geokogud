package ee.ttu.geocollection.interop.api.doi.service.impl;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.builder.details.FluentGeoApiDetailsBuilder;
import ee.ttu.geocollection.interop.api.builder.search.FluentDoiSearchApiBuilder;
import ee.ttu.geocollection.interop.api.doi.pojo.DoiSearchCriteria;
import ee.ttu.geocollection.interop.api.doi.service.DoiApiService;
import ee.ttu.geocollection.interop.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class DoiApiServiceImpl implements DoiApiService {
    @Autowired
    private ApiService apiService;
    private List<String> fields = Arrays.asList(
            "id",
            "identifier",
            "creators",
            "publisher",
            "publication_year",
            "abstract",
            "reference__author",
            "reference__year",
            "reference__title",
            "reference__journal__journal_short",
            "reference__volume",
            "reference__pages",
            "resource_type__value",
            "resource",
            "methods",
            "version",
            "sizes",
            "formats",
            "language__value",
            "language__value_en",
            "subjects",
            "copyright_agent__agent",
            "licence__licence_en",
            "licence__licence_url_en",
            "dataset__name",
            "dataset__name_en",
            "date_added",
            "date_changed",
            "datacite_created",
            "datacite_updated",
            "doiattachment__attachment__filename"
    );

    @Override
    public ApiResponse findDoi(DoiSearchCriteria searchCriteria)  {
        String requestParams = FluentDoiSearchApiBuilder.aRequest()
                .queryId(searchCriteria.getId())
                .queryIdentifier(searchCriteria.getDoi())
                .queryTitle(searchCriteria.getTitle())
                .queryPublishedBy(searchCriteria.getPublishedBy())
                .queryYear(searchCriteria.getYearSince())
                .queryYear(searchCriteria.getYearTo())
                .queryAuthor(searchCriteria.getAuthor())
                .queryAbstract(searchCriteria.getAbstractText())
                .queryInstitutions(searchCriteria.getDbs())
                .buildDefaultFieldsQuery();
        return apiService.searchRawEntities("doi", searchCriteria.getPage(), searchCriteria.getSortField(), requestParams);
    }

    @Override
    public Map findRawById(Long id) {
        String requestParams = FluentGeoApiDetailsBuilder.aRequest()
                .id(id)
                .relatedData("doi_agent")
                .relatedData("doi_geolocation")
                .relatedData("doi_related_identifier")
                .returnAllFields(fields)
                .buildWithReturningFieldsAndRelatedData();
        return apiService.findRawEntity("doi", requestParams);
    }

}