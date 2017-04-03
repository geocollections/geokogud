package ee.ttu.geocollection.interop.api.deserializer.protoPojo;

import ee.ttu.geocollection.interop.api.common.Country;

import java.math.BigDecimal;

public class Locality {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Long maaametPaId;

    private Country country;

    public Long getMaaametPaId() {
        return maaametPaId;
    }

    public void setMaaametPaId(Long maaametPaId) {
        this.maaametPaId = maaametPaId;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
