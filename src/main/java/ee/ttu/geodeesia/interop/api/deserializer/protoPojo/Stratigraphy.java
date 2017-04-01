package ee.ttu.geodeesia.interop.api.deserializer.protoPojo;

public class Stratigraphy {
    private Long id;
    private String stratigraphy;
    private String stratigraphyEn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(String stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public String getStratigraphyEn() {
        return stratigraphyEn;
    }

    public void setStratigraphyEn(String stratigraphyEn) {
        this.stratigraphyEn = stratigraphyEn;
    }
}
