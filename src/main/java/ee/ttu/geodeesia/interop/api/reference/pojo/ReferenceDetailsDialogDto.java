package ee.ttu.geodeesia.interop.api.reference.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;

public class ReferenceDetailsDialogDto {
    private Response drillCore;

    public ReferenceDetailsDialogDto(Response drillCore) {
        this.drillCore = drillCore;
    }

    public Response getDrillCore() {
        return drillCore;
    }

    public void setDrillCore(Response drillCore) {
        this.drillCore = drillCore;
    }
}