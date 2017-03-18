package ee.ttu.geodeesia.interop.api.samples.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ConvertableToResponseEntity;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SampleEntity implements Serializable, ConvertableToResponseEntity {
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

    private String numberAdditional;

    private Long localityId;

    private String locality;

    private String localityEn;

    private Double localityLatitude;

    private Double localityLongitude;

    private Long stratigraphyId;

    private String stratigraphy;

    private String stratigraphyEng;

    private String agent;

    private String git;

    private String remarks;
    @JsonProperty("depth")
    private Double depth;

    private Double depthInterval;

    @JsonProperty("mass")
    private String mass;

    @JsonProperty("rock")
    private String rock;
    private String classificationRockName;
    private String classificationRockNameEn;

    private String dateCollectedFree;

    private String soilSiteId;

    @JsonProperty("soilSiteId")
    public String getSoilSiteId() {
        return soilSiteId;
    }

    @JsonProperty("soil_site_id")
    public void setSoilSiteId(String soilSiteId) {
        this.soilSiteId = soilSiteId;
    }

    @JsonProperty("classificationRockName")
    public String getClassificationRockName() {
        return classificationRockName;
    }
    @JsonProperty("classification_rock__name")
    public void setClassificationRockName(String classificationRockName) {
        this.classificationRockName = classificationRockName;
    }
    @JsonProperty("classificationRockNameEn")
    public String getClassificationRockNameEn() {
        return classificationRockNameEn;
    }
    @JsonProperty("classification_rock__name_en")
    public void setClassificationRockNameEn(String classificationRockNameEn) {
        this.classificationRockNameEn = classificationRockNameEn;
    }

    @JsonProperty("dateCollectedFree")
    public String getDateCollectedFree() {
        return dateCollectedFree;
    }
    @JsonProperty("date_collected_free")
    public void setDateCollectedFree(String dateCollectedFree) {
        this.dateCollectedFree = dateCollectedFree;
    }

    @JsonProperty("depthInterval")
    public Double getDepthInterval() {
        return depthInterval;
    }
    @JsonProperty("depth_interval")
    public void setDepthInterval(Double depthInterval) {
        this.depthInterval = depthInterval;
    }

    @JsonProperty("numberAdditional")
    public String getNumberAdditional() {
        return numberAdditional;
    }
    @JsonProperty("number_additional")
    public void setNumberAdditional(String numberAdditional) {
        this.numberAdditional = numberAdditional;
    }
    @JsonProperty("localityId")
    public Long getLocalityId() {
        return localityId;
    }
    @JsonProperty("locality_id")
    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }
    @JsonProperty("localityEn")
    public String getLocalityEn() {
        return localityEn;
    }
    @JsonProperty("locality__locality_en")
    public void setLocalityEn(String localityEn) {
        this.localityEn = localityEn;
    }
    @JsonProperty("localityLatitude")
    public Double getLocalityLatitude() {
        return localityLatitude;
    }
    @JsonProperty("locality__latitude")
    public void setLocalityLatitude(Double localityLatitude) {
        this.localityLatitude = localityLatitude;
    }
    @JsonProperty("localityLongitude")
    public Double getLocalityLongitude() {
        return localityLongitude;
    }
    @JsonProperty("locality__longitude")
    public void setLocalityLongitude(Double localityLongitude) {
        this.localityLongitude = localityLongitude;
    }
    @JsonProperty("stratigraphyEng")
    public String getStratigraphyEng() {
        return stratigraphyEng;
    }
    @JsonProperty("stratigraphy__stratigraphy_en")
    public void setStratigraphyEng(String stratigraphyEng) {
        this.stratigraphyEng = stratigraphyEng;
    }
    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }
    @JsonProperty("locality__locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }
    @JsonProperty("stratigraphyId")
    public Long getStratigraphyId() {
        return stratigraphyId;
    }
    @JsonProperty("stratigraphy_id")
    public void setStratigraphyId(Long stratigraphyId) {
        this.stratigraphyId = stratigraphyId;
    }

    @JsonProperty("stratigraphy")
    public String getStratigraphy() {
        return stratigraphy;
    }
    @JsonProperty("stratigraphy__stratigraphy")
    public void setStratigraphy(String stratigraphy) {
        this.stratigraphy = stratigraphy;
    }
    @JsonProperty("agent")
    public String getAgent() {
        return agent;
    }
    @JsonProperty("agent_collected__agent")
    public void setAgent(String agent) {
        this.agent = agent;
    }
    @JsonProperty("remarks")
    public String getRemarks() {
        return remarks;
    }
    @JsonProperty("remarks_location")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @JsonProperty("git")
    public String getGit() {
        return git;
    }
    @JsonProperty("database__acronym")
    public void setGit(String git) {
        this.git = git;
    }

    @Override
    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setNumber(this.number);
        response.setNumberAdditional(this.numberAdditional);
        response.setLocalityId(this.localityId);
        response.setLocality(this.locality);
        response.setLocalityEng(this.localityEn);
        response.setLatitude(this.localityLatitude);
        response.setLongitude(this.localityLongitude);
        response.setStratigraphyId(this.stratigraphyId);
        response.setStratigraphy(this.stratigraphy);
        response.setStratigraphyEng(this.stratigraphyEng);
        response.setAgent(this.agent);
        response.setGIT(this.git);
        response.setRemarks(this.remarks);
        response.setDepth(this.depth);
        response.setDepthInterval(this.depthInterval);
        response.setMass(this.mass);
        return response;
    }
}
