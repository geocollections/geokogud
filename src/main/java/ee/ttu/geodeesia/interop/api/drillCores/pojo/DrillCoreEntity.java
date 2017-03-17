package ee.ttu.geodeesia.interop.api.drillCores.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DrillCoreEntity {

    private Long id;
    private String drillcore;
    private String boxNumbers;
    private String storageLocation;
    private String localityCountry;
    private String localityCountryEng;
    private String latitude;
    private String longitude;
    private String depth;
    private String boxes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrillcore() {
        return drillcore;
    }

    public void setDrillcore(String drillcore) {
        this.drillcore = drillcore;
    }
    @JsonProperty("boxNumbers")
    public String getBoxNumbers() {
        return boxNumbers;
    }
    @JsonProperty("box_numbers")
    public void setBoxNumbers(String boxNumbers) {
        this.boxNumbers = boxNumbers;
    }
    @JsonProperty("storageLocation")
    public String getStorageLocation() {
        return storageLocation;
    }
    @JsonProperty("storage__location")
    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
    @JsonProperty("localityCountryValue")
    public String getLocalityCountry() {
        return localityCountry;
    }
    @JsonProperty("locality__country__value")
    public void setLocalityCountry(String localityCountry) {
        this.localityCountry = localityCountry;
    }
    @JsonProperty("localityCountryValueEng")
    public String getLocalityCountryEng() {
        return localityCountryEng;
    }
    @JsonProperty("locality__country__value_en")
    public void setLocalityCountryEng(String localityCountryEng) {
        this.localityCountryEng = localityCountryEng;
    }
    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }
    @JsonProperty("locality__latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }
    @JsonProperty("locality__longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getBoxes() {
        return boxes;
    }

    public void setBoxes(String boxes) {
        this.boxes = boxes;
    }
}
