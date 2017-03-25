package ee.ttu.geodeesia.interop.api.stratigraphies.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ConvertableToResponseEntity;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StratigraphyEnitity implements Serializable, ConvertableToResponseEntity {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long id;
    @JsonProperty("stratigraphy")
    private String stratigraphy;
    @JsonProperty("stratigraphy_en")
    private String stratigraphyEn;
    @JsonProperty("rank__value")
    private String rankValue;
    @JsonProperty("rank__value_en")
    private String rankValueEng;
    @JsonProperty("scope__value")
    private String scopeValue;
    @JsonProperty("scope__value_en")
    private String scoreValueEng;
    @JsonProperty("index_main")
    private String indexMain;
    @JsonProperty("index_additional")
    private String indexAdditional;
    @JsonProperty("index_main_html")
    private String indexMainHtml;
    @JsonProperty("index_additional_html")
    private String indexAdditionalHtml;
    @JsonProperty("parent__stratigraphy")
    private String parentStratigraphy;
    @JsonProperty("parent__stratigraphy_en")
    private String parentStratigraphyEn;

    @Override
    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setStratigraphy(this.stratigraphy);
        response.setStratigraphyEng(this.stratigraphyEn);
        response.setRankValue(this.rankValue);
        response.setRankValueEng(this.rankValueEng);
        response.setScopeValue(this.scopeValue);
        response.setScopeValue(this.scoreValueEng);
        response.setIndexMain(this.indexMain);
        response.setIndexMainHtml(this.indexMainHtml);
        response.setIndexAdditional(this.indexAdditional);
        response.setIndexAdditionalHtml(this.indexAdditionalHtml);
        return response;
    }

}
