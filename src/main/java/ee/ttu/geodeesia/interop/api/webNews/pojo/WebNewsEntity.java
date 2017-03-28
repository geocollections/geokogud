package ee.ttu.geodeesia.interop.api.webNews.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebNewsEntity {

    private int id;
    private String titleEt;
    private String titleEn;
    private String textEt;
    private String textEn;
    private String dateAdded;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleEt() {
        return titleEt;
    }

    @JsonProperty("title_et")
    public void setTitleEt(String titleEt) {
        this.titleEt = titleEt;
    }

    public String getTitleEn() {
        return titleEn;
    }

    @JsonProperty("title_en")
    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTextEt() {
        return textEt;
    }

    @JsonProperty("text_et")
    public void setTextEt(String textEt) {
        this.textEt = textEt;
    }

    public String getTextEn() {
        return textEn;
    }

    @JsonProperty("text_en")
    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    @JsonProperty("date_added")
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
