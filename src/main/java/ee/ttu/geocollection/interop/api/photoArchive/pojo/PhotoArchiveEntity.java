package ee.ttu.geocollection.interop.api.photoArchive.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static ee.ttu.geocollection.interop.api.builder.ApiFields.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoArchiveEntity {
    /*
                "id": 28794,
                "filename": "MI16-3-23.jpg",
                "date_taken": "2016-10-06",
                "author__agent": "Isakar"
     */
    private Long id;
    private String dateTaken;
    private String authorAgent;
    private String locality;
    private String imageNumber;
    private String keywords;
    private String object;

    private String authorForename;
    private String authorSurename;
    private String localityEn;
    private String description;
    private String fileName;
    private String dataAdded;
    private String dataChanged;
    private String sizeX;
    private String sizeY;
    private String typeValue;
    private String typeValueEn;
    private String deviceName;
    private String country;
    private String countryEn;
    private String imagesetNumber;
    private String imagesetSeries;
    private String licence;
    private String licenceUrl;
    private String localityId;
    private String databaseAcronym;

    @JsonProperty("databaseAcronym")
    public String getDatabaseAcronym() {
        return databaseAcronym;
    }

    @JsonProperty("database__acronym")
    public void setDatabaseAcronym(String databaseAcronym) {
        this.databaseAcronym = databaseAcronym;
    }

    @JsonProperty("localityId")
    public String getLocalityId() {
        return localityId;
    }

    @JsonProperty("locality_id")
    public void setLocalityId(String localityId) {
        this.localityId = localityId;
    }

    @JsonProperty("licence")
    public String getLicence() {
        return licence;
    }

    @JsonProperty(LICENCE)
    public void setLicence(String licence) {
        this.licence = licence;
    }

    @JsonProperty("licenceUrl")
    public String getLicenceUrl() {
        return licenceUrl;
    }

    @JsonProperty(LICENCE_URL)
    public void setLicenceUrl(String licenceUrl) {
        this.licenceUrl = licenceUrl;
    }

    @JsonProperty("imagesetSeries")
    public String getImagesetSeries() {
        return imagesetSeries;
    }

    @JsonProperty(IMAGESET_SERIES)
    public void setImagesetSeries(String imagesetSeries) {
        this.imagesetSeries = imagesetSeries;
    }

    @JsonProperty("imagesetNumber")
    public String getImagesetNumber() {
        return imagesetNumber;
    }

    @JsonProperty(IMAGESET_NUMBER)
    public void setImagesetNumber(String imagesetNumber) {
        this.imagesetNumber = imagesetNumber;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("locality__country__value")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("countryEn")
    public String getCountryEn() {
        return countryEn;
    }

    @JsonProperty("locality__country__value_en")
    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    @JsonProperty("device__name")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @JsonProperty("typeValue")
    public String getTypeValue() {
        return typeValue;
    }

    @JsonProperty("type__value")
    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    @JsonProperty("typeValueEn")
    public String getTypeValueEn() {
        return typeValueEn;
    }

    @JsonProperty("type__value_en")
    public void setTypeValueEn(String typeValueEn) {
        this.typeValueEn = typeValueEn;
    }

    @JsonProperty("sizeX")
    public String getSizeX() {
        return sizeX;
    }

    @JsonProperty("size_x")
    public void setSizeX(String sizeX) {
        this.sizeX = sizeX;
    }

    @JsonProperty("sizeY")
    public String getSizeY() {
        return sizeY;
    }

    @JsonProperty("size_y")
    public void setSizeY(String sizeY) {
        this.sizeY = sizeY;
    }

    @JsonProperty("dataAdded")
    public String getDataAdded() {
        return dataAdded;
    }

    @JsonProperty("date_added")
    public void setDataAdded(String dataAdded) {
        this.dataAdded = dataAdded;
    }

    @JsonProperty("dataChanged")
    public String getDataChanged() {
        return dataChanged;
    }

    @JsonProperty("date_changed")
    public void setDataChanged(String dataChanged) {
        this.dataChanged = dataChanged;
    }

    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("filename")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("localityEn")
    public String getLocalityEn() {
        return localityEn;
    }

    @JsonProperty("locality__locality_en")
    public void setLocalityEn(String localityEn) {
        this.localityEn = localityEn;
    }

    @JsonProperty("authorForename")
    public String getAuthorForename() {
        return authorForename;
    }

    @JsonProperty("author__forename")
    public void setAuthorForename(String authorForename) {
        this.authorForename = authorForename;
    }

    @JsonProperty("authorSurename")
    public String getAuthorSurename() {
        return authorSurename;
    }

    @JsonProperty("author__surename")
    public void setAuthorSurename(String authorSurename) {
        this.authorSurename = authorSurename;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("imageNumber")
    public String getImageNumber() {
        return imageNumber;
    }

    @JsonProperty("image_number")
    public void setImageNumber(String imageNumber) {
        this.imageNumber = imageNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("dateTaken")
    public String getDateTaken() {
        return dateTaken;
    }

    @JsonProperty("date_taken")
    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    @JsonProperty("authorAgent")
    public String getAuthorAgent() {
        return authorAgent;
    }

    @JsonProperty("author__agent")
    public void setAuthorAgent(String authorAgent) {
        this.authorAgent = authorAgent;
    }

    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }

    @JsonProperty("locality__locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }
}
