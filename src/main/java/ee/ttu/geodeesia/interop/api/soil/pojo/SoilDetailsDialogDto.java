package ee.ttu.geodeesia.interop.api.soil.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.samples.pojo.Sample;

public class SoilDetailsDialogDto {
    private Soil soil;
    private Response<Sample> samples;

    public SoilDetailsDialogDto(Soil soil, Response<Sample> samples) {
        this.soil = soil;
        this.samples = samples;
    }

    public Response<Sample> getSamples() {
        return samples;
    }

    public void setSamples(Response<Sample> samples) {
        this.samples = samples;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

}