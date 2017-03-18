package ee.ttu.geodeesia.interop.api.localities.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;

public class LocalityDetailsDialogDto {
    private Response locality;

    public LocalityDetailsDialogDto(Response locality) {
        this.locality = locality;
    }

    public Response getLocality() {
        return locality;
    }

    public void setLocality(Response locality) {
        this.locality = locality;
    }
}