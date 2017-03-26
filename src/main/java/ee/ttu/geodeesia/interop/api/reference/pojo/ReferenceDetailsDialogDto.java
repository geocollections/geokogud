package ee.ttu.geodeesia.interop.api.reference.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;

public class ReferenceDetailsDialogDto {
    private Response reference;

    public ReferenceDetailsDialogDto(Response reference) {
        this.reference = reference;
    }

    public Response getReference() {
        return reference;
    }

    public void setReference(Response reference) {
        this.reference = reference;
    }
}