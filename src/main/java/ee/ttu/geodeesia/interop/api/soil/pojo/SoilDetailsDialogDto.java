package ee.ttu.geodeesia.interop.api.soil.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;
import ee.ttu.geodeesia.interop.api.samples.pojo.SampleEntity;

public class SoilDetailsDialogDto {
    private Response<SoilApiResponse> soil;
    private Response<SampleEntity> samples;

    public SoilDetailsDialogDto() {
    }

    public SoilDetailsDialogDto(Response soil, Response samples) {
        this.soil = soil;
        this.samples = samples;
    }

    public Response getSoil() {
        return soil;
    }

    public void setSoil(Response soil) {
        this.soil = soil;
    }

    public Response getSamples() {
        return samples;
    }

    public void setSamples(Response samples) {
        this.samples = samples;
    }
}