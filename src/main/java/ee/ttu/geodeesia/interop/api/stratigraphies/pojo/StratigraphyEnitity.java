package ee.ttu.geodeesia.interop.api.stratigraphies.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StratigraphyEnitity {
    private Long id;
    private String stratigraphy;
    private String stratigraphyEn;
    private String rankValue;
    private String rankValueEng;
    private String scopeValue;
    private String scopeValueEng;
    private String indexMain;
    private String indexAdditional;
    private String indexMainHtml;
    private String indexAdditionalHtml;
    private String parentStratigraphy;
    private String parentStratigraphyEn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(String stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    @JsonProperty("stratigraphyEn")
    public String getStratigraphyEn() {
        return stratigraphyEn;
    }

    @JsonProperty("stratigraphy_en")
    public void setStratigraphyEn(String stratigraphyEn) {
        this.stratigraphyEn = stratigraphyEn;
    }

    @JsonProperty("rankValue")
    public String getRankValue() {
        return rankValue;
    }

    @JsonProperty("rank__value")
    public void setRankValue(String rankValue) {
        this.rankValue = rankValue;
    }

    @JsonProperty("rankValueEng")
    public String getRankValueEng() {
        return rankValueEng;
    }

    @JsonProperty("rank__value_en")
    public void setRankValueEng(String rankValueEng) {
        this.rankValueEng = rankValueEng;
    }

    @JsonProperty("scopeValue")
    public String getScopeValue() {
        return scopeValue;
    }

    @JsonProperty("scope__value")
    public void setScopeValue(String scopeValue) {
        this.scopeValue = scopeValue;
    }

    @JsonProperty("scopeValueEng")
    public String getScopeValueEng() {
        return scopeValueEng;
    }

    @JsonProperty("scope__value_en")
    public void setScopeValueEng(String scopeValueEng) {
        this.scopeValueEng = scopeValueEng;
    }

    @JsonProperty("indexMain")
    public String getIndexMain() {
        return indexMain;
    }

    @JsonProperty("index_main")
    public void setIndexMain(String indexMain) {
        this.indexMain = indexMain;
    }

    @JsonProperty("indexAdditional")
    public String getIndexAdditional() {
        return indexAdditional;
    }

    @JsonProperty("index_additional")
    public void setIndexAdditional(String indexAdditional) {
        this.indexAdditional = indexAdditional;
    }

    @JsonProperty("indexMainHtml")
    public String getIndexMainHtml() {
        return indexMainHtml;
    }

    @JsonProperty("index_main_html")
    public void setIndexMainHtml(String indexMainHtml) {
        this.indexMainHtml = indexMainHtml;
    }

    @JsonProperty("indexAdditionalHtml")
    public String getIndexAdditionalHtml() {
        return indexAdditionalHtml;
    }

    @JsonProperty("index_additional_html")
    public void setIndexAdditionalHtml(String indexAdditionalHtml) {
        this.indexAdditionalHtml = indexAdditionalHtml;
    }

    @JsonProperty("parentStratigraphy")
    public String getParentStratigraphy() {
        return parentStratigraphy;
    }

    @JsonProperty("parent__stratigraphy")
    public void setParentStratigraphy(String parentStratigraphy) {
        this.parentStratigraphy = parentStratigraphy;
    }

    @JsonProperty("parentStratigraphyEn")
    public String getParentStratigraphyEn() {
        return parentStratigraphyEn;
    }

    @JsonProperty("parent__stratigraphy_en")
    public void setParentStratigraphyEn(String parentStratigraphyEn) {
        this.parentStratigraphyEn = parentStratigraphyEn;
    }
}
