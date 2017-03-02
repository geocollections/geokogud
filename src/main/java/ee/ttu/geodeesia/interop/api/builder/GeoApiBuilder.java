package ee.ttu.geodeesia.interop.api.builder;

public class GeoApiBuilder {


    private GeoApiBuilder() {
    }
    public static GeoApiBuilder aRequest() {
        return new GeoApiBuilder();
    }

}
