package ee.ttu.geodeesia.interop.api.drillCores.pojo;

import ee.ttu.geodeesia.interop.api.common.GeoEntity;
import ee.ttu.geodeesia.interop.api.deserializer.protoPojo.Stratigraphy;

public class DrillcoreBox implements GeoEntity{
    private String id;
    private String number;
    private String depthStart;
    private String depthEnd;
    private String depthOther;
    private String numberMeters;
    private Stratigraphy stratigraphyTop;
    private Stratigraphy stratigraphyBase;
    private Drillcoreimage drillcoreimage;

    public String getDepthOther() {
        return depthOther;
    }

    public void setDepthOther(String depthOther) {
        this.depthOther = depthOther;
    }

    public String getNumberMeters() {
        return numberMeters;
    }

    public void setNumberMeters(String numberMeters) {
        this.numberMeters = numberMeters;
    }

    public Drillcoreimage getDrillcoreimage() {
        return drillcoreimage;
    }

    public void setDrillcoreimage(Drillcoreimage drillcoreimage) {
        this.drillcoreimage = drillcoreimage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepthStart() {
        return depthStart;
    }

    public void setDepthStart(String depthStart) {
        this.depthStart = depthStart;
    }

    public String getDepthEnd() {
        return depthEnd;
    }

    public void setDepthEnd(String depthEnd) {
        this.depthEnd = depthEnd;
    }

    public Stratigraphy getStratigraphyTop() {
        return stratigraphyTop;
    }

    public void setStratigraphyTop(Stratigraphy stratigraphyTop) {
        this.stratigraphyTop = stratigraphyTop;
    }

    public Stratigraphy getStratigraphyBase() {
        return stratigraphyBase;
    }

    public void setStratigraphyBase(Stratigraphy stratigraphyBase) {
        this.stratigraphyBase = stratigraphyBase;
    }

    @Override
    public void addRelatedData(Object relatedData) {

    }
}
