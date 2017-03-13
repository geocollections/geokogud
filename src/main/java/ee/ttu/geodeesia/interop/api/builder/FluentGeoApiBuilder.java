package ee.ttu.geodeesia.interop.api.builder;

import ee.ttu.geodeesia.search.domain.SearchField;
import org.apache.commons.lang3.StringUtils;

public class FluentGeoApiBuilder {

    private static final String ID = "id";
    private static final String SITE = "site";
    private static final String AREA_NAME = "area_name";
    private static final String SOIL = "soil";
    private static final String LAND_USE = "land_use";
    private static final String IS_DEEP = "is_deep";
    private static final String TRANSECT = "transect";
    private static final String TRANSECT_POINT = "transect_point";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";

    //DOI search
    private static final String REFERENCE = "reference";
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String YEAR = "year";
    private static final String DOI = "doi";

    // Photo archive search
    private static final String FILE_NAME = "filename";
    private static final String DATE_TAKEN = "date_taken";
    private static final String AUTHOR_AGENT = "author__agent";

    private String query = StringUtils.EMPTY;
    private String returnFields = StringUtils.EMPTY;
    private String lastQueryField = StringUtils.EMPTY;

    private FluentGeoApiBuilder() {
    }

    public static FluentGeoApiBuilder aRequest() {
        return new FluentGeoApiBuilder();
    }

    public FluentGeoApiBuilder fieldIsNotNull(String field) {
        query += "&" + field + "__isnull=false";
        return this;
    }

    public FluentGeoApiBuilder andReturn() {
        addReturningField(lastQueryField);
        return this;
    }

    public FluentGeoApiBuilder queryId(SearchField id) {
        query += buildFieldParameters(ID, id);
        return this;
    }

    public FluentGeoApiBuilder querySite(SearchField site) {
        query += buildFieldParameters(SITE, site);
        return this;
    }

    public FluentGeoApiBuilder queryAreaName(SearchField areaName) {
        query += buildFieldParameters(AREA_NAME, areaName);
        return this;
    }

    public FluentGeoApiBuilder querySoil(SearchField soil) {
        query += buildFieldParameters(SOIL, soil);
        return this;
    }

    public FluentGeoApiBuilder queryLandUse(SearchField landUse) {
        query += buildFieldParameters(LAND_USE, landUse);
        return this;
    }

    public FluentGeoApiBuilder queryTransect(SearchField transect) {
        query += buildFieldParameters(TRANSECT, transect);
        return this;
    }

    public FluentGeoApiBuilder queryDeepMining(Boolean deep) {
        if (deep != null) {
            String isDeep = booleanToString(deep);
            query += "&" + IS_DEEP + "=" + isDeep;
            lastQueryField = IS_DEEP;
        }
        return this;
    }

    public FluentGeoApiBuilder queryFileName(SearchField id) {
        query += buildFieldParameters(FILE_NAME, id);
        return this;
    }

    public FluentGeoApiBuilder queryDateTaken(SearchField id) {
        query += buildFieldParameters(DATE_TAKEN, id);
        return this;
    }

    public FluentGeoApiBuilder queryAuthorAgent(SearchField id) {
        query += buildFieldParameters(AUTHOR_AGENT, id);
        return this;
    }

    public FluentGeoApiBuilder returnTransectPoint() {
        addReturningField(TRANSECT_POINT);
        return this;
    }

    public FluentGeoApiBuilder returnLatitude() {
        addReturningField(LATITUDE);
        return this;
    }

    public FluentGeoApiBuilder returnLongitude() {
        addReturningField(LONGITUDE);
        return this;
    }

    private void addReturningField(String field) {
        returnFields += returnFields.isEmpty() ? field : "," + field;
    }

    public FluentGeoApiBuilder querySpecimenNumber(SearchField specimenNumber) {
        query += buildFieldParameters("specimen_nr", specimenNumber);
        return this;
    }

    public FluentGeoApiBuilder queryClassification(SearchField classification) {
        query += buildFieldParameters("classification__class_field", classification);
        return this;
    }

    public FluentGeoApiBuilder queryLocality(SearchField locality) {
        query += buildFieldParameters("locality__locality", locality);
        return this;
    }

    public FluentGeoApiBuilder queryDepth(SearchField depth) {
        query += buildFieldParameters("depth", depth);
        return this;
    }

    public FluentGeoApiBuilder queryStratigraphy(SearchField stratigraphy) {
        query += buildFieldParameters("stratigraphy__stratigraphy", stratigraphy);
        return this;
    }

    public FluentGeoApiBuilder queryMineralRock(SearchField mineralRock) {
        query += buildFieldParameters("specimenidentification__name", mineralRock);
        return this;
    }

    public FluentGeoApiBuilder queryTitle(SearchField title) {
        query += buildFieldParameters(TITLE, title);
        return this;
    }

    public FluentGeoApiBuilder queryDoi(SearchField doi) {
        query += buildFieldParameters(DOI, doi);
        return this;
    }

    public FluentGeoApiBuilder queryAuthor(SearchField author) {
        query += buildFieldParameters(AUTHOR, author);
        return this;
    }

    public FluentGeoApiBuilder queryYear(SearchField year) {
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
