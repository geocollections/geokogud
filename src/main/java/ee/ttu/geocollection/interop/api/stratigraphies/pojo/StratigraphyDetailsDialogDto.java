package ee.ttu.geocollection.interop.api.stratigraphies.pojo;

import ee.ttu.geocollection.interop.api.Response.Response;

public class StratigraphyDetailsDialogDto {
    private Response<StratigraphyEnitity> stratigraphy;

    public StratigraphyDetailsDialogDto(Response<StratigraphyEnitity> stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public Response<StratigraphyEnitity> getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(Response<StratigraphyEnitity> stratigraphy) {
        this.stratigraphy = stratigraphy;
    }
}
