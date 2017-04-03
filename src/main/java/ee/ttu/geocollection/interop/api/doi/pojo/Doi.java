package ee.ttu.geocollection.interop.api.doi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Doi {
    /*
{
            "id": 1,
            "identifier": "10.15152/GEO.1",
            "creators": "Hints, Olle; Martma, Tõnu",
            "publisher": "Institute of Geology at Tallinn University of Technology",
            "publication_year": "2014",
            "abstract": null,
            "reference__author": "Hints, O., Martma, T., Männik, P., Nõlvak, J., Põldvere, A., Shen, Y. & Viira, V.",
            "reference__year": "2014",
            "reference__title": "New data on Ordovician stable isotope record and conodont biostratigraphy from the Viki reference drill core, Saaremaa Island, western Estonia",

            "reference__journal__journal_short": "GFF",
            "reference__volume": "136",
            "reference__pages": "100-104",
            "resource_type__value": "Dataset",
            "resource": "Geochemistry",
            "methods": "Isotopic composition of bulk carbonate was measured using Thermo Scientific Delta V mass-spectrometer at the Institute of Geology at Tallinn University of Technology. Reproducability better than 0.1 permil.",
            "version": "1.0",
            "sizes": "254 data points",
            "formats": "text/plain; application/xlsx",
            "language__value": "inglise",
            "language__value_en": "English",
            "subjects": "Ordovician; carbon isotopes; Baltoscandia; Estonia",
            "copyright_agent__agent": "TTÜ GI",
            "licence__licence_en": "CC BY",
            "licence__licence_url_en": "http://creativecommons.org/licenses/by/3.0/",
            "dataset__name": "Viki stabiilsed isotoobid (Ordovitsium ja alam-Silur)",
            "dataset__name_en": "Stable carbon isotopes from the Viki drill core (Ordovician and lower Silurian)",
            "date_added": "2014-10-09T00:00:00Z",
            "date_changed": "2014-12-08T10:53:43Z",
            "datacite_created": "2014-12-08T11:29:37",
            "datacite_updated": "2014-12-08T11:29:37"
        }
    */


    private Long id;
    private String identifier;
    private String creators;
    private String publisher;
    private String publicationYear;
    private String abstractText;
    private String referenceAuthor;
    private String referenceYear;
    private String referenceTitle;

    private String journalShort;
    private String volume;
    private String pages;
    private String resourceType;
    private String resource;
    private String methods;
    private String version;
    private String sizes;
    private String formats;
    private String language;
    private String languageEn;
    private String subjects;
    private String copyrightAgent;
    private String licenceEn;
    private String licenceUrlEn;
    private String datasetName;
    private String datasetNameEn;
    private String dateAdded;
    private String dateChanged;
    private String dataciteCreated;
    private String dataciteUpdated;


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    @JsonProperty("publicationYear")
    public String getPublicationYear() {
        return publicationYear;
    }

    @JsonProperty("publication_year")
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
    @JsonProperty("abstract")
    public String getAbstractText() {
        return abstractText;
    }
    @JsonProperty("abstract")
    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }
    @JsonProperty("author")
    public String getReferenceAuthor() {
        return referenceAuthor;
    }
    @JsonProperty("reference__author")
    public void setReferenceAuthor(String referenceAuthor) {
        this.referenceAuthor = referenceAuthor;
    }
    @JsonProperty("year")
    public String getReferenceYear() {
        return referenceYear;
    }
    @JsonProperty("reference__year")
    public void setReferenceYear(String referenceYear) {
        this.referenceYear = referenceYear;
    }
    @JsonProperty("title")
    public String getReferenceTitle() {
        return referenceTitle;
    }
    @JsonProperty("reference__title")
    public void setReferenceTitle(String referenceTitle) {
        this.referenceTitle = referenceTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonProperty("journalShort")
    public String getJournalShort() {
        return journalShort;
    }
    @JsonProperty("reference__journal__journal_short")
    public void setJournalShort(String journalShort) {
        this.journalShort = journalShort;
    }
    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }
    @JsonProperty("reference__volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }
    @JsonProperty("pages")
    public String getPages() {
        return pages;
    }
    @JsonProperty("reference__pages")
    public void setPages(String pages) {
        this.pages = pages;
    }
    @JsonProperty("resourceType")
    public String getResourceType() {
        return resourceType;
    }
    @JsonProperty("resource_type__value")
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getFormats() {
        return formats;
    }

    public void setFormats(String formats) {
        this.formats = formats;
    }
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }
    @JsonProperty("language__value")
    public void setLanguage(String language) {
        this.language = language;
    }
    @JsonProperty("languageEn")
    public String getLanguageEn() {
        return languageEn;
    }
    @JsonProperty("language__value_en")
    public void setLanguageEn(String languageEn) {
        this.languageEn = languageEn;
    }

    public String getSubjects() {
        return subjects;
    }
    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
    @JsonProperty("copyrightAgent")
    public String getCopyrightAgent() {
        return copyrightAgent;
    }
    @JsonProperty("copyright_agent__agent")
    public void setCopyrightAgent(String copyrightAgent) {
        this.copyrightAgent = copyrightAgent;
    }
    @JsonProperty("licenceEn")
    public String getLicenceEn() {
        return licenceEn;
    }
    @JsonProperty("licence__licence_en")
    public void setLicenceEn(String licenceEn) {
        this.licenceEn = licenceEn;
    }
    @JsonProperty("licenceUrlEn")
    public String getLicenceUrlEn() {
        return licenceUrlEn;
    }
    @JsonProperty("licence__licence_url_en")
    public void setLicenceUrlEn(String licenceUrlEn) {
        this.licenceUrlEn = licenceUrlEn;
    }
    @JsonProperty("datasetName")
    public String getDatasetName() {
        return datasetName;
    }
    @JsonProperty("dataset__name")
    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }
    @JsonProperty("datasetNameEn")
    public String getDatasetNameEn() {
        return datasetNameEn;
    }
    @JsonProperty("private String dataset__name_en;")
    public void setDatasetNameEn(String datasetNameEn) {
        this.datasetNameEn = datasetNameEn;
    }
    @JsonProperty("dateAdded")
    public String getDateAdded() {
        return dateAdded;
    }
    @JsonProperty("date_added")
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
    @JsonProperty("dateChanged")
    public String getDateChanged() {
        return dateChanged;
    }
    @JsonProperty("date_changed")
    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }
    @JsonProperty("dataciteCreated")
    public String getDataciteCreated() {
        return dataciteCreated;
    }
    @JsonProperty("datacite_created")
    public void setDataciteCreated(String dataciteCreated) {
        this.dataciteCreated = dataciteCreated;
    }
    @JsonProperty("dataciteUpdated")
    public String getDataciteUpdated() {
        return dataciteUpdated;
    }
    @JsonProperty("datacite_updated")
    public void setDataciteUpdated(String dataciteUpdated) {
        this.dataciteUpdated = dataciteUpdated;
    }
}
