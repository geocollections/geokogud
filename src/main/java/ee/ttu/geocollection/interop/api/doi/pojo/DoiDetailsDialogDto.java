package ee.ttu.geocollection.interop.api.doi.pojo;

import ee.ttu.geocollection.interop.api.Response.Response;

public class DoiDetailsDialogDto {
    private Response doi;

    public DoiDetailsDialogDto(Response doi) {
        this.doi = doi;
    }

    public Response getDoi() {
        return doi;
    }

    public void setDoi(Response doi) {
        this.doi = doi;
    }
}