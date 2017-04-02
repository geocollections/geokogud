package ee.ttu.geodeesia.interop.api.samples.pojo;

import ee.ttu.geodeesia.interop.api.common.GeoEntity;

public class Sample implements GeoEntity{

    private String id;
    private String numberAdditional;
    private String soilHorizon;
    private String remarks;
    private String depth;
    private String depthInterval;

    @Override
    public void addRelatedData(Object relatedData) {

    }

    public String getDepthInterval() {
        return depthInterval;
    }

    public void setDepthInterval(String depthInterval) {
        this.depthInterval = depthInterval;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumberAdditional() {
        return numberAdditional;
    }

    public void setNumberAdditional(String numberAdditional) {
        this.numberAdditional = numberAdditional;
    }

    public String getSoilHorizon() {
        return soilHorizon;
    }

    public void setSoilHorizon(String soilHorizon) {
        this.soilHorizon = soilHorizon;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
