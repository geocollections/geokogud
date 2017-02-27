package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiServiceSample implements Serializable {
    private static final long serialVersionUID = 1L;

/*
    "id":141502,
    "number":null,
    "number_additional":"32",
    "locality_id":14574,
    "locality__locality":"Whitcliffe Road, Ludlow",
    "locality__locality_en":"Whitcliffe Road, Ludlow",
    "locality__latitude":52.362933,
    "locality__longitude":-2.719083,
    "locality_free":null,
    "locality__country__value":"UK",
    "locality__country__value_en":"United Kingdom",
    "soil_site__site":null,
    "soil_site__site_en":null,
    "soil_site__latitude":null,
    "soil_site__longitude":null,
    "stratigraphy__stratigraphy":"Ludlow",
    "stratigraphy__stratigraphy_en":"Ludlow",
    "lithostratigraphy__stratigraphy":null,
    "lithostratigraphy__stratigraphy_en":null,
    "stratigraphy_bed":null,
    "agent_collected__agent":"Kaljo","agent_collected_free":null,
    "date_collected":"1979-04-02","date_collected_free":null,
    "depth":null,
    "depth_interval":null,
    "classification_rock__name":"aleuroliit",
    "classification_rock__name_en":"siltstone",
    "rock":null,"rock_en":null,
    "location":null,
    "mass":null,
    "remarks":"Tõenäoliselt sama proov ID79698",
    "series_id":null,
    "database__acronym":"GIT"
*/
    @JsonProperty("id")
    private Long id;
    @JsonProperty("number")
    private String number;
    @JsonProperty("number_additional")
    private String numberAdditional;
    @JsonProperty("locality_id")
    private String localityId;
    @JsonProperty("locality__locality")
    private String locality;
    @JsonProperty("locality__locality_en")
    private String localityEn;
    @JsonProperty("locality__latitude")
    private Double localityLatitude;
    @JsonProperty("locality__longitude")
    private Double localityLongitude;

    @JsonProperty("stratigraphy__stratigraphy")
    private String stratigraphy;
    @JsonProperty("stratigraphy__stratigraphy_en")
    private String stratigraphyEng;

    @JsonProperty("agent_collected__agent")
    private String agent;
    @JsonProperty("database__acronym")
    private String git;
    @JsonProperty("remarks_location")
    private String remarks;
    @JsonProperty("depth")
    private Double depth;

    @JsonProperty("mass")
    private String mass;


    public ResponseEntities toResponse() {
        ResponseEntities response = new ResponseEntities();
        response.setId(this.id);
        response.setNumber(this.number);
        response.setNumberAdditional(this.numberAdditional);
        response.setLocality(this.locality);
        response.setLocalityEn(this.localityEn);
        response.setLatitude(this.localityLatitude);
        response.setLongitude(this.localityLongitude);
        response.setStratigraphy(this.stratigraphy);
        response.setStratigraphyEng(this.stratigraphyEng);
        response.setAgent(this.agent);
        response.setGIT(this.git);
        response.setRemarks(this.remarks);
        response.setDepth(this.depth);
        response.setMass(this.mass);
        return response;
    }
}
