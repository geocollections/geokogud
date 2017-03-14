package ee.ttu.geodeesia.interop.api.builder;

import ee.ttu.geodeesia.search.domain.SearchField;
import org.apache.commons.lang3.StringUtils;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentGeoApiSearchBuilder {
    private String query = StringUtils.EMPTY;
    private String returnFields = StringUtils.EMPTY;
    private String lastQueryField = StringUtils.EMPTY;

    private FluentGeoApiSearchBuilder() {
    }

    public static FluentGeoApiSearchBuilder aRequest() {
        return new FluentGeoApiSearchBuilder();
    }

    public FluentGeoApiSearchBuilder fieldIsNotNull(String field) {
        query += "&" + field + "__isnull=false";
        return this;
    }

    public FluentGeoApiSearchBuilder andReturn() {
        addReturningField(lastQueryField);
        return this;
    }

    public FluentGeoApiSearchBuilder queryId(SearchField id) {
        query += buildFieldParameters(ID, id);
        return this;
    }

    public FluentGeoApiSearchBuilder querySite(SearchField site) {
        query += buildFieldParameters(SITE, site);
        return this;
    }

    public FluentGeoApiSearchBuilder queryAreaName(SearchField areaName) {
        query += buildFieldParameters(AREA_NAME, areaName);
        return this;
    }

    public FluentGeoApiSearchBuilder querySoil(SearchField soil) {
        query += buildFieldParameters(SOIL, soil);
        return this;
    }

    public FluentGeoApiSearchBuilder queryLandUse(SearchField landUse) {
        query += buildFieldParameters(LAND_USE, landUse);
        return this;
    }

    public FluentGeoApiSearchBuilder queryTransect(SearchField transect) {
        query += buildFieldParameters(TRANSECT, transect);
        return this;
    }

    public FluentGeoApiSearchBuilder queryDeepMining(Boolean deep) {
        if (deep != null) {
            String isDeep = booleanToString(deep);
            query += "&" + IS_DEEP + "=" + isDeep;
            lastQueryField = IS_DEEP;
        }
        return this;
    }

    public FluentGeoApiSearchBuilder queryFileName(SearchField id) {
        query += buildFieldParameters(FILE_NAME, id);
        return this;
    }

    public FluentGeoApiSearchBuilder queryDateTaken(SearchField id) {
        query += buildFieldParameters(DATE_TAKEN, id);
        return this;
    }

    public FluentGeoApiSearchBuilder queryAuthorAgent(SearchField id) {
        query += buildFieldParameters(AUTHOR_AGENT, id);
        return this;
    }

    public FluentGeoApiSearchBuilder returnTransectPoint() {
        addReturningField(TRANSECT_POINT);
        return this;
    }

    public FluentGeoApiSearchBuilder returnLatitude() {
        addReturningField(LATITUDE);
        return this;
    }

    public FluentGeoApiSearchBuilder returnLongitude() {
        addReturningField(LONGITUDE);
        return this;
    }

    private void addReturningField(String field) {
        returnFields += returnFields.isEmpty() ? field : "," + field;
    }

    public FluentGeoApiSearchBuilder querySpecimenNumber(SearchField specimenNumber) {
        query += buildFieldParameters("specimen_nr", specimenNumber);
        return this;
    }

    public FluentGeoApiSearchBuilder queryClassification(SearchField classification) {
        query += buildFieldParameters("classification__class_field", classification);
        return this;
    }

    public FluentGeoApiSearchBuilder queryLocality(SearchField locality) {
        query += buildFieldParameters("locality__locality", locality);
        return this;
    }

    public FluentGeoApiSearchBuilder queryDepth(SearchField depth) {
        query += buildFieldParameters("depth", depth);
        return this;
    }

    public FluentGeoApiSearchBuilder queryStratigraphy(SearchField stratigraphy) {
        query += buildFieldParameters("stratigraphy__stratigraphy", stratigraphy);
        return this;
    }

    public FluentGeoApiSearchBuilder queryMineralRock(SearchField mineralRock) {
        query += buildFieldParameters("specimenidentification__name", mineralRock);
        return this;
    }

    public FluentGeoApiSearchBuilder queryTitle(SearchField title) {
        query += buildFieldParameters(TITLE, title);
        return this;
    }

    public FluentGeoApiSearchBuilder queryDoi(SearchField doi) {
        query += buildFieldParameters(DOI, doi);
        return this;
    }

    public FluentGeoApiSearchBuilder queryAuthor(SearchField author) {
        query += buildFieldParameters(AUTHOR, author);
        return this;
    }

    public FluentGeoApiSearchBuilder queryYear(SearchField year) {
        query += buildFieldParameters(YEAR, year);
        return this;
    }

    public String build() {
        return query + "&fields=" + returnFields;
    }

    private String buildFieldParameters(String fieldName, SearchField searchField) {
        this.lastQueryField = fieldName;
        return isNotNullAndEmpty(searchField) ? "&" + fieldName + "__" + extractFieldParameters(searchField) : StringUtils.EMPTY;
    }

    private String extractFieldParameters(SearchField searchField) {
        return searchField.getLookUpType().value() + "=" + searchField.getName();
    }

    private boolean isNotNullAndEmpty(SearchField field) {
        return field != null && StringUtils.isNotBlank(field.getName());
    }

    private String booleanToString(Boolean flag) {
        return flag ? "1" : "0";
    }
}
