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
    private String fileName;
    private String dateTaken;
    private String authorAgent;
    private String localityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }
    @JsonProperty("filename")
    public void setFileName(String fileName) {
        this.fileName = fileName;
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
    @JsonProperty("localityId")
    public String getLocalityId() {
        return localityId;
    }
    @JsonProperty("locality_id")
    public void setLocalityId(String localityId) {
        this.localityId = localityId;
    }
}
