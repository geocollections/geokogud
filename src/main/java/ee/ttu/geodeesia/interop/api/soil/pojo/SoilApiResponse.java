package ee.ttu.geodeesia.interop.api.soil.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.search.domain.Coordinates;

import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SoilApiResponse {
    private Long id;
    private String site;
    private String areaOfStudy;
    private String transect;
    private String transectPoint;
    private String soil;
    private String landUse;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private boolean deep;

    public String getTransect() {
        return transect;
    }

    public void setTransect(String transect) {
        this.transect = transect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @JsonProperty("areaOfStudy")
    public String getAreaOfStudy() {
        return areaOfStudy;
    }

    @JsonProperty("area_name")
    public void setAreaOfStudy(String areaOfStudy) {
        this.areaOfStudy = areaOfStudy;
    }

    @JsonProperty("transectPoint")
    public String getTransectPoint() {
        return transectPoint;
    }

    @JsonProperty("transect_point")
    public void setTransectPoint(String transectPoint) {
        this.transectPoint = transectPoint;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    @JsonProperty("landUse")
    public String getLandUse() {
        return landUse;
    }

    @JsonProperty("land_use")
    public void setLandUse(String landUse) {
        this.landUse = landUse;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("isDeep")
    public boolean isDeep() {
        return deep;
    }

    @JsonProperty("is_deep")
    public void setDeep(boolean deep) {
        this.deep = deep;
    }
}
