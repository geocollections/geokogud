package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by 48707222248 on 19.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalityApiResponse {
    @JsonProperty("results")
    private List<Locality> result;
}
