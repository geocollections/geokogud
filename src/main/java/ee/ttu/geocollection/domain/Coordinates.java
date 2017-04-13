package ee.ttu.geocollection.domain;

import java.math.BigDecimal;

public class Coordinates {
    private BigDecimal longitute;
    private BigDecimal latitude;

    public BigDecimal getLongitute() {
        return longitute;
    }

    public void setLongitute(BigDecimal longitute) {
        this.longitute = longitute;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
