package ee.ttu.geodeesia.interop.api.photoArchive.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

public class PhotoArchiveEntity {
/*
            "id": 28794,
            "filename": "MI16-3-23.jpg",
            "date_taken": "2016-10-06",
            "author__agent": "Isakar"
 */
    @JsonProperty("id")
    private Long id;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("date_taken")
    private String date_taken;
    @JsonProperty("author__agent")
    private String author__agent;
    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setFilename(this.filename);
        response.setDate_taken(this.date_taken);
        response.setAuthor__agent(this.author__agent);
        return response;
    }
}
