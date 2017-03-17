package ee.ttu.geodeesia.interop.api.drillCores.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;

public class DrillCoreDetailsDialogDto {
    private Response drillCore;

    public DrillCoreDetailsDialogDto(Response drillCore) {
        this.drillCore = drillCore;
    }

    public Response getDrillCore() {
        return drillCore;
    }

    public void setDrillCore(Response drillCore) {
        this.drillCore = drillCore;
    }
}