package ee.ttu.geodeesia.interop.api.drillCores.pojo;

import ee.ttu.geodeesia.interop.api.common.Agent;
import ee.ttu.geodeesia.interop.api.common.Database;
import ee.ttu.geodeesia.interop.api.common.GeoEntity;
import ee.ttu.geodeesia.interop.api.deserializer.protoPojo.Locality;

import java.util.ArrayList;
import java.util.List;

public class DrillCoreProto implements GeoEntity {
    private Long id;
    private String drillcore;
    private String drillcoreEn;
    private Long localityId;
    private String boxes;
    private String boxNumbers;
    private String depth;
    private Integer year;
    private Double numberMeters;
    private String remarks;

    private Storage storage;
    private Agent agent;
    private Locality locality;
    private Depository depository;
    private Database database;

    private List<DrillcoreBox> drillcoreBoxes;

    public List<DrillcoreBox> getDrillcoreBoxes() {
        return drillcoreBoxes;
    }

    public void setDrillcoreBoxes(List<DrillcoreBox> drillcoreBoxes) {
        this.drillcoreBoxes = drillcoreBoxes;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Depository getDepository() {
        return depository;
    }

    public void setDepository(Depository depository) {
        this.depository = depository;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getNumberMeters() {
        return numberMeters;
    }

    public void setNumberMeters(Double numberMeters) {
        this.numberMeters = numberMeters;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDrillcoreEn() {
        return drillcoreEn;
    }

    public void setDrillcoreEn(String drillcoreEn) {
        this.drillcoreEn = drillcoreEn;
    }

    public Long getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

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

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
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

    @Override
    public void addRelatedData(Object relatedData) {
        if (relatedData instanceof DrillcoreBox) {
            if (drillcoreBoxes == null) {
                drillcoreBoxes = new ArrayList<>();
            }
            drillcoreBoxes.add((DrillcoreBox) relatedData);
        }
    }
}
