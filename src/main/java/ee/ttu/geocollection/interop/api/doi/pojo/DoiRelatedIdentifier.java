package ee.ttu.geocollection.interop.api.doi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Olesja Senkiv on 26.03.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DoiRelatedIdentifier {
/*     {
                "value": "10.3176/earth.2014.31",
                "identifier_type__value": "DOI",
                "relation_type__value": "IsSupplementTo"
            }
    */
    @JsonProperty("value")
    private String value;
    private String identifierType;
    private String relatedType;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @JsonProperty("identifierType")
    public String getIdentifierType() {
        return identifierType;
    }
    @JsonProperty("identifier_type__value")
    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }
    @JsonProperty("relatedType")
    public String getRelatedType() {
        return relatedType;
    }
    @JsonProperty("relation_type__value")
    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }
}
