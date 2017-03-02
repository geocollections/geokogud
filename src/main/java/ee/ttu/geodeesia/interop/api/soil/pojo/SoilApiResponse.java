package ee.ttu.geodeesia.interop.api.soil.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.search.domain.Coordinates;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SoilApiResponse {
    @JsonProperty("id")
    private Long id;
    private String locality;
    private String areaOfStudy;
    private String pointOnTransect;
    @JsonProperty("soil")
    private String soilName;
    @JsonProperty("land_use")
    private String landUse;
    private Coordinates coordinates;
    private boolean deepMining;

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

    public String getAreaOfStudy() {
        return areaOfStudy;
    }

    public void setAreaOfStudy(String areaOfStudy) {
        this.areaOfStudy = areaOfStudy;
    }

    public String getPointOnTransect() {
        return pointOnTransect;
    }

    public void setPointOnTransect(String pointOnTransect) {
        this.pointOnTransect = pointOnTransect;
    }

    public String getSoilName() {
        return soilName;
    }

    public void setSoilName(String soilName) {
        this.soilName = soilName;
    }

    public String getLandUse() {
        return landUse;
    }

    public void setLandUse(String landUse) {
        this.landUse = landUse;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isDeepMining() {
        return deepMining;
    }

    public void setDeepMining(boolean deepMining) {
        this.deepMining = deepMining;
    }
}
