package ee.ttu.geodeesia.interop.api.deserializer.protoPojo;

public class DrillcoreBox {
    private String id;
    private String number;
    private String depthStart;
    private String depthEnd;
    private Stratigraphy stratigraphyTop;
    private Stratigraphy stratigraphyBase;

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
}
