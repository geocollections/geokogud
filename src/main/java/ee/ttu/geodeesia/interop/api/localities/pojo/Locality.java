package ee.ttu.geodeesia.interop.api.localities.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locality {
    /*    "id": 21104,
            "locality": "Lagedi puurauk",
            "locality_en": "Lagedi borehole",
            "number": "",
            "country__value": "Eesti",
            "country__value_en": "Estonia",
            "maakond__maakond": "Harjumaa",
            "maakond__maakond_en": "Harju County",
            "vald__vald": "Rae",
            "vald__vald_en": "Rae",
            "remarks_location": "Puurauk asub Lagedi külast lõunas, kuid põhja pool raudteed. Koordinaadid orienteerivad.",
            "asustusyksus__asustusyksus": "Lagedi alevik",
            "asustusyksus__asustusyksus_en": "Lagedi",
            "latitude": 59.39515,
            "longitude": 24.957647,
            "stratigraphy_base_id": 111,
            "stratigraphy_base__stratigraphy": "Tremadoci lade",
            "stratigraphy_base__stratigraphy_en": "Tremadocian",
            "stratigraphy_top_id": 23,
            "stratigraphy_top__stratigraphy": "Kukruse lade",
            "stratigraphy_top__stratigraphy_en": "Kukruse Stage",
            "elevation": 42.0,
            "depth": 35.82,
            "eelis": null,
            "maaamet_pa_id": null,
            "type__value": "puurauk",
            "type__value_en": "borehole (section)",
            "parent__locality": null*/
    @JsonProperty("id")
    private Long id;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("locality_en")
    private String localityEn;
    @JsonProperty("number")
    private String number;
    @JsonProperty("country__value")
    private String countryValue;
    @JsonProperty("country__value_en")
    private String countryValueEn;
    @JsonProperty("maakond__maakond")
    private String county;
    @JsonProperty("maakond__maakond_en")
    private String countyEn;
    @JsonProperty("vald__vald")
    private String area;
    @JsonProperty("vald__vald_en")
    private String areaEn;
    @JsonProperty("remarks_location")
    private String remarks;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("elevation")
    private Double elevation;
    @JsonProperty("depth")
    private Double depth;
    private Double maPaId;

    @JsonProperty("maPaId")
    public Double getMaPaId() {
        return maPaId;
    }
    @JsonProperty("maaamet_pa_id")
    public void setMaPaId(Double maPaId) {
        this.maPaId = maPaId;
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

    public String getLocalityEn() {
        return localityEn;
    }

    public void setLocalityEn(String localityEn) {
        this.localityEn = localityEn;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryValue() {
        return countryValue;
    }

    public void setCountryValue(String countryValue) {
        this.countryValue = countryValue;
    }

    public String getCountryValueEn() {
        return countryValueEn;
    }

    public void setCountryValueEn(String countryValueEn) {
        this.countryValueEn = countryValueEn;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyEn() {
        return countyEn;
    }

    public void setCountyEn(String countyEn) {
        this.countyEn = countyEn;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaEn() {
        return areaEn;
    }

    public void setAreaEn(String areaEn) {
        this.areaEn = areaEn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
