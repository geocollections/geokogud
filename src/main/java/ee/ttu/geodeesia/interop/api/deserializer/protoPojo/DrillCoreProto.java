package ee.ttu.geodeesia.interop.api.deserializer.protoPojo;

public class DrillCoreProto {
    private Long id;
    private String drillcore;
    private String boxes;
    private String depth;
    private LocalityProto locality;

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
}
