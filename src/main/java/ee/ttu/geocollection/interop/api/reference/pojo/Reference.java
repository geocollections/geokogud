package ee.ttu.geocollection.interop.api.reference.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Reference {
    /*
    {"id":1,
    "reference":"Bekker, 1921",
    "author":"Bekker, H.",
    "year":"1921",
    "title":"The Kuckers Stage of the Ordovician Rocks in N-E Estonia",
    "title_original":null,
    "language__value_en":"English",
    "journal":203,
    "journal__journal_name":"Acta Univ. Tartu",
    "journal_additional":null,
    "volume":"A II",
    "book":null,
    "pages":"1-90",
    "doi":null,
    "remarks":null}*/


    private Long id;
    private String reference;
    private String author;
    private String title;
    private String year;
    private String titleOriginal;
    private String languageEng;
    private String journal;
    private String journalName;
    private String journalAdditional;
    private String volume;
    private String book;
    private String pages;
    private String doi;
    private String remarks;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    @JsonProperty("titleOriginal")
    public String getTitleOriginal() {
        return titleOriginal;
    }
    @JsonProperty("title_original")
    public void setTitleOriginal(String titleOriginal) {
        this.titleOriginal = titleOriginal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonProperty("languageEng")
    public String getLanguageEng() {
        return languageEng;
    }
    @JsonProperty("language__value_en")
    public void setLanguageEng(String languageEng) {
        this.languageEng = languageEng;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
    @JsonProperty("journalName")
    public String getJournalName() {
        return journalName;
    }
    @JsonProperty("journal__journal_name")
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }
    @JsonProperty("journalAdditional")
    public String getJournalAdditional() {
        return journalAdditional;
    }
    @JsonProperty("journal_additional")
    public void setJournalAdditional(String journalAdditional) {
        this.journalAdditional = journalAdditional;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
