package ee.ttu.geodeesia.interop.api.deserializer.protoPojo;

public class DrillCoreProto {
    private Long id;
    private String drillcore;
    private String boxes;
    private String boxNumbers;
    private Storage storage;
    private String depth;
    private LocalityProto locality;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getBoxNumbers() {
        return boxNumbers;
    }

    public void setBoxNumbers(String boxNumbers) {
        this.boxNumbers = boxNumbers;
    }

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

    public LocalityProto getLocality() {
        return locality;
    }

    public void setLocality(LocalityProto locality) {
        this.locality = locality;
    }

    public String getBoxes() {
        return boxes;
    }

    public void setBoxes(String boxes) {
        this.boxes = boxes;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }
}
