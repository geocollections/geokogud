package ee.ttu.geodeesia.interop.api.drillCores.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ConvertableToResponseEntity;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

public class DrillCoresEntity implements ConvertableToResponseEntity {
    /*
    {
                "id": 42
    }
     */
    @JsonProperty("id")
    private Long id;

    @Override
    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        return response;
    }
}
