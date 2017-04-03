package ee.ttu.geocollection.interop.api.localities.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalityApiResponse {
    @JsonProperty("results")
    private List<Locality> result;
}
