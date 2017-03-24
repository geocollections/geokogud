package ee.ttu.geodeesia.interop.api.localities.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;

public class LocalityDetailsDialogDto {
    private Response locality;
    private Response references;
    private Response specimens;

    public LocalityDetailsDialogDto(Response locality, Response references, Response specimens) {
        this.locality = locality;
        this.references = references;
        this.specimens = specimens;
    }

    public Response getReferences() {
        return references;
    }

    public void setReferences(Response references) {
        this.references = references;
    }

    public Response getSpecimens() {
        return specimens;
    }

    public void setSpecimens(Response specimens) {
        this.specimens = specimens;
    }

    public Response getLocality() {
        return locality;
    }

    public void setLocality(Response locality) {
        this.locality = locality;
    }
}