package ee.ttu.geodeesia.interop.api.reference.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceEntity {
    private static final long serialVersionUID = 1L;
    /*
                "id": 6304,
                "reference": "Loog & Kivimägi, 1970",
                "author": "Loog, A. & Kivimägi, E.",
                "year": "1970",
                "title": "On the distribution of Estonian obolid phosphorites",
                "title_original": "О распространении оболовых фосфоритов Эстонии",
                "language__value_en": "Russian",
                "journal": 53,
                "journal__journal_name": "Proceedings of the Academy of Sciences of the Estonian SSR. Chemistry and Geology",
                "journal_additional": null,
                "volume": "19",
                "book": null,
                "pages": "92",
                "doi": null,
                "remarks": null
         */
    @JsonProperty("id")
    private Long id;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("author")
    private String author;
    @JsonProperty("year")
    private String year;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_original")
    private String title_original;
    @JsonProperty("language__value_en")
    private String language__value_en;
    @JsonProperty("journal")
    private String journal;
    @JsonProperty("journal__journal_name")
    private String journal__journal_name;
    @JsonProperty("journal_additional")
    private String journal_additional;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("book")
    private String book;
    @JsonProperty("pages")
    private String pages;
    @JsonProperty("doi")
    private String doi;
    @JsonProperty("remarks")
    private String remarks;

    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setReference(this.reference);
        response.setAuthor(this.author);
        response.setYear(this.year);
        response.setTitle(this.title);
        response.setTitle_original(this.title_original);
        response.setLanguage__value_en(this.language__value_en);
        response.setJournal(this.journal);
        response.setJournal__journal_name(this.journal__journal_name);
        response.setJournal_additional(this.journal_additional);
        response.setVolume(this.volume);
        response.setBook(this.book);
        response.setPages(this.pages);
        response.setDoi(this.doi);
        response.setRemarks(this.remarks);
        return response;
    }
}
