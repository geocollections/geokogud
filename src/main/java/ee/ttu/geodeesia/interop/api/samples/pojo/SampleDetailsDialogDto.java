package ee.ttu.geodeesia.interop.api.samples.pojo;

import ee.ttu.geodeesia.interop.api.Response.Response;

public class SampleDetailsDialogDto {
    private Response sample;

    public SampleDetailsDialogDto(Response sample) {
        this.sample = sample;
    }

    public Response getSample() {
        return sample;
    }

    public void setSample(Response sample) {
        this.sample = sample;
    }
}