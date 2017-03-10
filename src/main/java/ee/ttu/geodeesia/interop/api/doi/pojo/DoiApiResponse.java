package ee.ttu.geodeesia.interop.api.doi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DoiApiResponse {
    private Long id;
    private String fileName;
    private String dateTaken;
    private String authorAgent;


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
}
