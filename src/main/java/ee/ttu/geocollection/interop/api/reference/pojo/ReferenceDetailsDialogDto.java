package ee.ttu.geocollection.interop.api.reference.pojo;

import ee.ttu.geocollection.interop.api.Response.Response;

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