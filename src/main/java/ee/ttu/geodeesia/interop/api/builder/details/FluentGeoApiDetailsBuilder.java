package ee.ttu.geodeesia.interop.api.builder.details;

import org.apache.commons.lang3.StringUtils;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

public class FluentGeoApiDetailsBuilder {
    private String query = StringUtils.EMPTY;

    public static FluentGeoApiDetailsBuilder aRequest() {
        return new FluentGeoApiDetailsBuilder();
    }

    public FluentGeoApiDetailsBuilder id(Long id) {
        query += id + "?fields=";
        return this;
    }

    public FluentGeoApiDetailsBuilder returnId() {
        query += addReturningField(ID);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnSite() {
        query += addReturningField(SITE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnAreaName() {
        query += addReturningField(AREA_NAME);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLandUse() {
        query += addReturningField(LAND_USE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnSoil() {
        query += addReturningField(SOIL);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnTransect() {
        query += addReturningField(TRANSECT);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnTransectPoint() {
        query += addReturningField(TRANSECT_POINT);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLatitude() {
        query += addReturningField(LATITUDE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLongitude() {
        query += addReturningField(LONGITUDE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDeepMining() {
        query += addReturningField(IS_DEEP);
        return this;
    }

    /* DRILL CORE */
    public FluentGeoApiDetailsBuilder returnDrillCore() {
        query += addReturningField(DRILL_CORE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnBoxNumbers() {
        query += addReturningField(BOX_NUMBERS);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnStorageLocation() {
        query += addReturningField(STORAGE_LOCATION);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityCountry() {
        query += addReturningField(LOCALITY_COUNTRY);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityCountryEng() {
        query += addReturningField(LOCALITY_COUNTRY_ENG);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityLatitude() {
        query += addReturningField(LOCALITY_LATITUDE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityLongitude() {
        query += addReturningField(LOCALITY_LONGITUDE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDepth() {
        query += addReturningField(DEPTH);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnBoxes() {
        query += addReturningField(BOXES);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnImageNumber() {
        query += addReturningField(IMAGE_NUMBER);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnAuthorAgent() {
        query += addReturningField(AUTHOR_AGENT);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnAuthorForename() {
        query += addReturningField(AUTHOR_FORENAME);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnAuthorSurename() {
        query += addReturningField(AUTHOR_SURENAME);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityLocality() {
        query += addReturningField(LOCALITY_LOCALITY);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityLocalityEn() {
        query += addReturningField(LOCALITY_LOCALITY_EN);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDateTaken() {
        query += addReturningField(DATE_TAKEN);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnObject() {
        query += addReturningField(OBJECT);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnKeywords() {
        query += addReturningField(KEYWORDS);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDescription() {
        query += addReturningField(DESCRIPTION);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnFilename() {
        query += addReturningField(FILE_NAME);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDataAdded() {
        query += addReturningField(DATA_ADDED);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDataChanged() {
        query += addReturningField(DATA_CHANGED);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnTypeValue() {
        query += addReturningField(TYPE_VALUE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnTypeValueEn() {
        query += addReturningField(TYPE_VALUE_EN);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnDeviceName() {
        query += addReturningField(DEVICE_NAME);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnImageSetNumber() {
        query += addReturningField(IMAGESET_NUMBER);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnImageSetSeries() {
        query += addReturningField(IMAGESET_SERIES);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLicence() {
        query += addReturningField(LICENCE);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLicenceUrl() {
        query += addReturningField(LICENCE_URL);
        return this;
    }

    public FluentGeoApiDetailsBuilder returnLocalityId() {
        query += addReturningField(LOCALITY_ID);
        return this;
    }

    private String addReturningField(String field) {
        return isFirstField() ? field : "," + field;
    }

    private boolean isFirstField() {
        return "=".equals(StringUtils.right(query, 1));
    }

    public String build() {
        return query;
    }

}
