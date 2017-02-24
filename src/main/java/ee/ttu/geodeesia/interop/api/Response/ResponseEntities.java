package ee.ttu.geodeesia.interop.api.Response;

/**
 * Created by 48707222248 on 24.02.2017.
 */
public class ResponseEntities {
    private Long id;
    private String number;
    private String numberAdditional;
    private String locality;
    private String localityEn;
    private Double latitude;
    private Double longitude;
    private String stratigraphy;
    private String stratigraphyEng;
    private String agent;
    private String GIT;
    private String remarks;
    private Double depth;
    private String mass;

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getNumberAdditional() {
        return numberAdditional;
    }

    public void setNumberAdditional(String numberAdditional) {
        this.numberAdditional = numberAdditional;
    }

    public String getLocality() {
        return locality;
    }

    public String getLocalityEn() {
        return localityEn;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getStratigraphy() {
        return stratigraphy;
    }

    public String getStratigraphyEng() {
        return stratigraphyEng;
    }

    public String getAgent() {
        return agent;
    }

    public String getGIT() {
        return GIT;
    }

    public String getRemarks() {
        return remarks;
    }

    public Double getDepth() {
        return depth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setLocalityEn(String localityEn) {
        this.localityEn = localityEn;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setStratigraphy(String stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public void setStratigraphyEng(String stratigraphyEng) {
        this.stratigraphyEng = stratigraphyEng;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setGIT(String GIT) {
        this.GIT = GIT;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }
}
