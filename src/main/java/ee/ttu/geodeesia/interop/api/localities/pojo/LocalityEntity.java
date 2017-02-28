package ee.ttu.geodeesia.interop.api.localities.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalityEntity implements Serializable {//Serializable
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

    @JsonProperty("stratigraphy_base_id")
    private Long stratigraphyBaseId;
    @JsonProperty("stratigraphy_base__stratigraphy")
    private String stratigraphyBaseStratigraphy;
    @JsonProperty("stratigraphy_base__stratigraphy_en")
    private String stratigraphyBaseStratigraphyEn;
    @JsonProperty("stratigraphy_top_id")
    private Long stratigraphyTopId;
    @JsonProperty("stratigraphy_top__stratigraphy")
    private String stratigraphyTopStratigraphy;
    @JsonProperty("stratigraphy_top__stratigraphy_en")
    private String stratigraphyTopStratigraphyEn;

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
