package ee.ttu.geodeesia.interop.api.localities.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ConvertableToResponseEntity;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalityEntity implements Serializable, ConvertableToResponseEntity {
    private static final long serialVersionUID = 1L;
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

    private String localityEn;
    @JsonProperty("number")
    private String number;

    private String countryValue;

    private String countryValueEn;

    private String county;

    private String countyEn;

    private String area;

    private String areaEn;

    private String remarks;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("elevation")
    private Double elevation;
    @JsonProperty("depth")
    private Double depth;

    private Long stratigraphyBaseId;

    private String stratigraphyBaseStratigraphy;
    private String stratigraphyBaseStratigraphyEn;

    private Long stratigraphyTopId;

    private String stratigraphyTopStratigraphy;

    private String stratigraphyTopStratigraphyEn;

    @JsonProperty("localityEn")
    public String getLocalityEn() {
        return localityEn;
    }
    @JsonProperty("locality_en")
    public void setLocalityEn(String localityEn) {
        this.localityEn = localityEn;
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
    @JsonProperty("remarks")
    public String getRemarks() {
        return remarks;
    }
    @JsonProperty("remarks_location")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @JsonProperty("stratigraphyBaseId")
    public Long getStratigraphyBaseId() {
        return stratigraphyBaseId;
    }
    @JsonProperty("stratigraphy_base_id")
    public void setStratigraphyBaseId(Long stratigraphyBaseId) {
        this.stratigraphyBaseId = stratigraphyBaseId;
    }
    @JsonProperty("stratigraphyBaseStratigraphy")
    public String getStratigraphyBaseStratigraphy() {
        return stratigraphyBaseStratigraphy;
    }
    @JsonProperty("stratigraphy_base__stratigraphy")
    public void setStratigraphyBaseStratigraphy(String stratigraphyBaseStratigraphy) {
        this.stratigraphyBaseStratigraphy = stratigraphyBaseStratigraphy;
    }

    @JsonProperty("stratigraphyBaseStratigraphyEn")
    public String getStratigraphyBaseStratigraphyEn() {
        return stratigraphyBaseStratigraphyEn;
    }

    @JsonProperty("stratigraphy_base__stratigraphy_en")
    public void setStratigraphyBaseStratigraphyEn(String stratigraphyBaseStratigraphyEn) {
        this.stratigraphyBaseStratigraphyEn = stratigraphyBaseStratigraphyEn;
    }
    @JsonProperty("stratigraphyTopId")
    public Long getStratigraphyTopId() {
        return stratigraphyTopId;
    }
    @JsonProperty("stratigraphy_top_id")
    public void setStratigraphyTopId(Long stratigraphyTopId) {
        this.stratigraphyTopId = stratigraphyTopId;
    }
    @JsonProperty("stratigraphyTopStratigraphy")
    public String getStratigraphyTopStratigraphy() {
        return stratigraphyTopStratigraphy;
    }
    @JsonProperty("stratigraphy_top__stratigraphy")
    public void setStratigraphyTopStratigraphy(String stratigraphyTopStratigraphy) {
        this.stratigraphyTopStratigraphy = stratigraphyTopStratigraphy;
    }
    @JsonProperty("stratigraphyTopStratigraphyEn")
    public String getStratigraphyTopStratigraphyEn() {
        return stratigraphyTopStratigraphyEn;
    }
    @JsonProperty("stratigraphy_top__stratigraphy_en")
    public void setStratigraphyTopStratigraphyEn(String stratigraphyTopStratigraphyEn) {
        this.stratigraphyTopStratigraphyEn = stratigraphyTopStratigraphyEn;
    }

    @Override
    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setNumber(this.number);
        response.setLocality(this.locality);
        response.setLocalityEn(this.localityEn);
        response.setLatitude(this.latitude);
        response.setLongitude(this.longitude);
        response.setRemarks(this.remarks);
        response.setDepth(this.depth);
        response.setCountry(this.countryValue);
        response.setCountryEn(this.countryValueEn);
        response.setStratigraphyBaseId(this.stratigraphyBaseId);
        response.setStratigraphyBase(this.stratigraphyBaseStratigraphy);
        response.setStratigraphBaseEng(this.stratigraphyBaseStratigraphyEn);
        response.setStratigraphyTopId(this.stratigraphyTopId);
        response.setStratigraphyTop(this.stratigraphyTopStratigraphy);
        response.setStratigraphTopEng(this.stratigraphyTopStratigraphyEn);
        return response;
    }
}
