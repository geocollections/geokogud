package ee.ttu.geodeesia.interop.api.localities.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Olesja Senkiv on 28.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalityApiResponse {
    @JsonProperty("results")
    private List<Locality> result;
}
