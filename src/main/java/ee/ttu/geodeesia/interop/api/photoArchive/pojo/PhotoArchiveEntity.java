package ee.ttu.geodeesia.interop.api.photoArchive.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ConvertableToResponseEntity;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

public class PhotoArchiveEntity {
    /*
                "id": 28794,
                "filename": "MI16-3-23.jpg",
                "date_taken": "2016-10-06",
                "author__agent": "Isakar"
     */
    private Long id;
    private String dateTaken;
    private String authorAgent;
    private String locality;
    private String imageNumber;
    private String keywords;
    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("imageNumber")
    public String getImageNumber() {
        return imageNumber;
    }

    @JsonProperty("image_number")
    public void setImageNumber(String imageNumber) {
        this.imageNumber = imageNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonProperty("dateTaken")
    public String getDateTaken() {
        return dateTaken;
    }
    @JsonProperty("date_taken")
    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }
    @JsonProperty("authorAgent")
    public String getAuthorAgent() {
        return authorAgent;
    }
    @JsonProperty("author__agent")
    public void setAuthorAgent(String authorAgent) {
        this.authorAgent = authorAgent;
    }
    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }
    @JsonProperty("locality__locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }
}
