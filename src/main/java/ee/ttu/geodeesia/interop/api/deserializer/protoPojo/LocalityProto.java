package ee.ttu.geodeesia.interop.api.deserializer.protoPojo;

import java.math.BigDecimal;

public class LocalityProto {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private CountryProto country;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public CountryProto getCountry() {
        return country;
    }

    public void setCountry(CountryProto country) {
        this.country = country;
    }
}
