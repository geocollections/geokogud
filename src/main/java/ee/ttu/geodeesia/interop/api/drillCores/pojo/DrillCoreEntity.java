package ee.ttu.geodeesia.interop.api.drillCores.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DrillCoreEntity {

        /*
            "id":22,
            "drillcore":"Apraksin Bor 17 puursÃ¼damik",
            "boxes":58,
            "depth":"15-274.8"
        */

    private Long id;
    private String drillcore;
    private String boxNumbers;
    private String storageLocation;

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
}
