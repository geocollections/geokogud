package ee.ttu.geocollection.interop.api.localities.pojo;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.Response.Response;

public class LocalityDetailsDialogDto {
    private Response locality;
    private Response references;
    private ApiResponse specimens;

    public LocalityDetailsDialogDto(Response locality, Response references, ApiResponse specimens) {
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

    public ApiResponse getSpecimens() {
        return specimens;
    }

    public void setSpecimens(ApiResponse specimens) {
        this.specimens = specimens;
    }

    public Response getLocality() {
        return locality;
    }

    public void setLocality(Response locality) {
        this.locality = locality;
    }
}