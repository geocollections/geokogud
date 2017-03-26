package ee.ttu.geodeesia.interop.api.doi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Olesja Senkiv on 26.03.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoiGeolocation {

/*    {
        "locality__locality": null,
            "locality__locality_en": null,
            "place": "Solberga 1 core section, central Sweden",
            "point": "60.9693582 15.2116068"
    }*/


    private String locality;
    @JsonProperty("place")
    private String place;
    @JsonProperty("point")
    private String point;

    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }
    @JsonProperty("locality__locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
