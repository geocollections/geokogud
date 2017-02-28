package ee.ttu.geodeesia.interop.api.Response;

public class ResponseEntity {
    private Long id;
    private String number;
    private String numberAdditional;
    private String locality;
    private String localityEn;
    private Double latitude;
    private Double longitude;

    private String agent;
    private String GIT;
    private String remarks;
    private Double depth;
    private String mass;

    private String country;
    private String countryEn;

    //specificaly used by locality //TODO:MAYBE realy must be separatly
    private Long stratigraphyBaseId;
    private String stratigraphyBase;
    private String stratigraphBaseEng;

    private Long stratigraphyTopId;
    private String stratigraphyTop;
    private String stratigraphTopEng;

    private Long stratigraphyId;
    private String stratigraphy;
    private String stratigraphyEng;

    //specificaly used by stratigraphy //TODO:MAYBE realy must be separatly
    private String rankValue;
    private String rankValueEn;
    private String scopeValue;
    private String statusValueEn;
    private String indexMain;
    private String indexAdditional;
    private String indexMainHtml;
    private String indexAdditionalHtml;
    private String parentStratigraphy;
    private String parentStratigraphyEn;

    public String getRankValue() {
        return rankValue;
    }

    public void setRankValue(String rankValue) {
        this.rankValue = rankValue;
    }

    public String getRankValueEn() {
        return rankValueEn;
    }

    public void setRankValueEn(String rankValueEn) {
        this.rankValueEn = rankValueEn;
    }

    public String getScopeValue() {
        return scopeValue;
    }

    public void setScopeValue(String scopeValue) {
        this.scopeValue = scopeValue;
    }

    public String getStatusValueEn() {
        return statusValueEn;
    }

    public void setStatusValueEn(String statusValueEn) {
        this.statusValueEn = statusValueEn;
    }

    public String getIndexMain() {
        return indexMain;
    }

    public void setIndexMain(String indexMain) {
        this.indexMain = indexMain;
    }

    public String getIndexAdditional() {
        return indexAdditional;
    }

    public void setIndexAdditional(String indexAdditional) {
        this.indexAdditional = indexAdditional;
    }

    public String getIndexMainHtml() {
        return indexMainHtml;
    }

    public void setIndexMainHtml(String indexMainHtml) {
        this.indexMainHtml = indexMainHtml;
    }

    public String getIndexAdditionalHtml() {
        return indexAdditionalHtml;
    }

    public void setIndexAdditionalHtml(String indexAdditionalHtml) {
        this.indexAdditionalHtml = indexAdditionalHtml;
    }

    public String getParentStratigraphy() {
        return parentStratigraphy;
    }

    public void setParentStratigraphy(String parentStratigraphy) {
        this.parentStratigraphy = parentStratigraphy;
    }

    public String getParentStratigraphyEn() {
        return parentStratigraphyEn;
    }

    public void setParentStratigraphyEn(String parentStratigraphyEn) {
        this.parentStratigraphyEn = parentStratigraphyEn;
    }

    public Long getStratigraphyBaseId() {
        return stratigraphyBaseId;
    }
    public void setStratigraphyBaseId(Long stratigraphyBaseId) {
        this.stratigraphyBaseId = stratigraphyBaseId;
    }

    public void setStratigraphyTopId(Long stratigraphyTopId) {
        this.stratigraphyTopId = stratigraphyTopId;
    }

    public void setStratigraphyId(Long stratigraphyId) {
        this.stratigraphyId = stratigraphyId;
    }

    public String getStratigraphyBase() {
        return stratigraphyBase;
    }

    public void setStratigraphyBase(String stratigraphyBase) {
        this.stratigraphyBase = stratigraphyBase;
    }

    public String getStratigraphBaseEng() {
        return stratigraphBaseEng;
    }

    public void setStratigraphBaseEng(String stratigraphBaseEng) {
        this.stratigraphBaseEng = stratigraphBaseEng;
    }

    public Long getStratigraphyTopId() {
        return stratigraphyTopId;
    }

    public String getStratigraphyTop() {
        return stratigraphyTop;
    }

    public void setStratigraphyTop(String stratigraphyTop) {
        this.stratigraphyTop = stratigraphyTop;
    }

    public String getStratigraphTopEng() {
        return stratigraphTopEng;
    }

    public void setStratigraphTopEng(String stratigraphTopEng) {
        this.stratigraphTopEng = stratigraphTopEng;
    }

    public Long getStratigraphyId() {
        return stratigraphyId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

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
