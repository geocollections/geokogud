package ee.ttu.geodeesia.interop.api.localities.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static ee.ttu.geodeesia.interop.api.builder.ApiFields.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locality {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("locality")
    private String locality;
    private String localityEn;
    @JsonProperty("number")
    private String number;
    private String countryValue;
    private String countryValueEn;
    private String county;
    private String countyEn;
    private String area;
    private String areaEn;
    private String remarksLocation;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("elevation")
    private Double elevation;
    @JsonProperty("depth")
    private Double depth;

    private String asustusYksus;
    private String coordSystem;
    @JsonProperty("coordx")
    private String coordX;
    @JsonProperty("coordy")
    private String coordY;
    private String coordPrecision;
    private String coordMethod;
    private String coordAgent;
    private String stratigraphyTopFree;
    private String stratigraphyBaseFree;
    private String remarks;
    private String userAdded;
    private String dateAdded;
    private String dateChanged;
    private String parentLocality;
    private String eelis;
    private String maaametPaId;
    private String type;
    private String stratigraphyTop;
    private String stratigraphyBase;

    @JsonProperty("stratigraphyBase")
    public String getStratigraphyBase() {
        return stratigraphyBase;
    }

    @JsonProperty("stratigraphy_base__stratigraphy")
    public void setStratigraphyBase(String stratigraphyBase) {
        this.stratigraphyBase = stratigraphyBase;
    }

    @JsonProperty("stratigraphyTop")
    public String getStratigraphyTop() {
        return stratigraphyTop;
    }

    @JsonProperty("stratigraphy_top__stratigraphy")
    public void setStratigraphyTop(String stratigraphyTop) {
        this.stratigraphyTop = stratigraphyTop;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type__value")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("maaametPaId")
    public String getMaaametPaId() {
        return maaametPaId;
    }

    @JsonProperty(MAAAMET_PA_ID)
    public void setMaaametPaId(String maaametPaId) {
        this.maaametPaId = maaametPaId;
    }

    @JsonProperty("eelis")
    public String getEelis() {
        return eelis;
    }

    @JsonProperty(EELIS)
    public void setEelis(String eelis) {
        this.eelis = eelis;
    }

    @JsonProperty("parentLocality")
    public String getParentLocality() {
        return parentLocality;
    }

    @JsonProperty(PARENT_LOCALITY)
    public void setParentLocality(String parentLocality) {
        this.parentLocality = parentLocality;
    }

    @JsonProperty("dateChanged")
    public String getDateChanged() {
        return dateChanged;
    }

    @JsonProperty(DATE_CHANGED)
    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }

    @JsonProperty("dateAdded")
    public String getDateAdded() {
        return dateAdded;
    }

    @JsonProperty(DATE_ADDED)
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @JsonProperty("userAdded")
    public String getUserAdded() {
        return userAdded;
    }

    @JsonProperty(USER_ADDED)
    public void setUserAdded(String userAdded) {
        this.userAdded = userAdded;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonProperty("stratigraphyBaseFree")
    public String getStratigraphyBaseFree() {
        return stratigraphyBaseFree;
    }

    @JsonProperty(STRATIGRAPHY_BASE_FREE)
    public void setStratigraphyBaseFree(String stratigraphyBaseFree) {
        this.stratigraphyBaseFree = stratigraphyBaseFree;
    }

    @JsonProperty("stratigraphyTopFree")
    public String getStratigraphyTopFree() {
        return stratigraphyTopFree;
    }

    @JsonProperty(STRATIGRAPHY_TOP_FREE)
    public void setStratigraphyTopFree(String stratigraphyTopFree) {
        this.stratigraphyTopFree = stratigraphyTopFree;
    }

    @JsonProperty("coordMethod")
    public String getCoordMethod() {
        return coordMethod;
    }

    @JsonProperty(COORD_DET_METHOD)
    public void setCoordMethod(String coordMethod) {
        this.coordMethod = coordMethod;
    }

    @JsonProperty("coordAgent")
    public String getCoordAgent() {
        return coordAgent;
    }

    @JsonProperty(COORD_DET_AGENT)
    public void setCoordAgent(String coordAgent) {
        this.coordAgent = coordAgent;
    }

    @JsonProperty("coordPrecision")
    public String getCoordPrecision() {
        return coordPrecision;
    }

    @JsonProperty(COORD_DET_PRECISION)
    public void setCoordPrecision(String coordPrecision) {
        this.coordPrecision = coordPrecision;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    @JsonProperty("coordSystem")
    public String getCoordSystem() {
        return coordSystem;
    }

    @JsonProperty(COORD_SYSTEM)
    public void setCoordSystem(String coordSystem) {
        this.coordSystem = coordSystem;
    }

    @JsonProperty("asustusYksus")
    public String getAsustusYksus() {
        return asustusYksus;
    }

    @JsonProperty(ASUSTUSYKSUS)
    public void setAsustusYksus(String asustusYksus) {
        this.asustusYksus = asustusYksus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @JsonProperty("localityEn")
    public String getLocalityEn() {
        return localityEn;
    }

    @JsonProperty("locality_en")
    public void setLocalityEn(String localityEn) {
        this.localityEn = localityEn;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("countryValue")
    public String getCountryValue() {
        return countryValue;
    }

    @JsonProperty("country__value")
    public void setCountryValue(String countryValue) {
        this.countryValue = countryValue;
    }

    @JsonProperty("countryValueEn")
    public String getCountryValueEn() {
        return countryValueEn;
    }

    @JsonProperty("country__value_en")
    public void setCountryValueEn(String countryValueEn) {
        this.countryValueEn = countryValueEn;
    }

    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    @JsonProperty("maakond__maakond")
    public void setCounty(String county) {
        this.county = county;
    }

    @JsonProperty("countyEn")
    public String getCountyEn() {
        return countyEn;
    }

    @JsonProperty("maakond__maakond_en")
    public void setCountyEn(String countyEn) {
        this.countyEn = countyEn;
    }

    @JsonProperty("area")
    public String getArea() {
        return area;
    }

    @JsonProperty("vald__vald")
    public void setArea(String area) {
        this.area = area;
    }

    @JsonProperty("areaEn")
    public String getAreaEn() {
        return areaEn;
    }

    @JsonProperty("vald__vald_en")
    public void setAreaEn(String areaEn) {
        this.areaEn = areaEn;
    }

    @JsonProperty("remarksLocation")
    public String getRemarksLocation() {
        return remarksLocation;
    }

    @JsonProperty("remarks_location")
    public void setRemarksLocation(String remarksLocation) {
        this.remarksLocation = remarksLocation;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }
}
