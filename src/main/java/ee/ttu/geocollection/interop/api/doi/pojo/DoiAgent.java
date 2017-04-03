package ee.ttu.geocollection.interop.api.doi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Olesja Senkiv on 26.03.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DoiAgent {
/*    {
        "affiliation": "GeoZentrum Nordbayern, University of Erlangen-Nürnberg",
            "name": "Lehnert, Oliver",
            "agent_type__value": "Creator"
    }*/
    @JsonProperty("affiliation")
    private String affiliation;
    @JsonProperty("name")
    private String name;
    private String agentType;

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("agentType")
    public String getAgentType() {
        return agentType;
    }
    @JsonProperty("agent_type__value")
    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }
}
