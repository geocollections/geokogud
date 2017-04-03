package ee.ttu.geocollection.interop.api.soil.pojo;

import ee.ttu.geocollection.interop.api.common.GeoEntity;

import java.math.BigDecimal;


public class Soil implements GeoEntity{
    private Long id;
    private String site;
 /*   private String areaOfStudy;*/
    private String transect;
    private String transectPoint;
    private String soil;
    private String landUse;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private boolean deep;
    private String coordx;
    private String coordy;
    private String coordSystem;
    private String kSizeA;
    private String kAsteA;
    private String date;
    private String dateFree;
    private String areaName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCoordx() {
        return coordx;
    }

    public void setCoordx(String coordx) {
        this.coordx = coordx;
    }

    public String getCoordy() {
        return coordy;
    }

    public void setCoordy(String coordy) {
        this.coordy = coordy;
    }

    public String getCoordSystem() {
        return coordSystem;
    }

    public void setCoordSystem(String coordSystem) {
        this.coordSystem = coordSystem;
    }

    public String getkSizeA() {
        return kSizeA;
    }

    public void setkSizeA(String kSizeA) {
        this.kSizeA = kSizeA;
    }

    public String getkAsteA() {
        return kAsteA;
    }

    public void setkAsteA(String kAsteA) {
        this.kAsteA = kAsteA;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateFree() {
        return dateFree;
    }

    public void setDateFree(String dateFree) {
        this.dateFree = dateFree;
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

    public String getTransect() {
        return transect;
    }

    public void setTransect(String transect) {
        this.transect = transect;
    }

    public String getTransectPoint() {
        return transectPoint;
    }

    public void setTransectPoint(String transectPoint) {
        this.transectPoint = transectPoint;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getLandUse() {
        return landUse;
    }

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

    public boolean isDeep() {
        return deep;
    }

    public void setDeep(boolean deep) {
        this.deep = deep;
    }

    @Override
    public void addRelatedData(Object relatedData) {

    }
}
