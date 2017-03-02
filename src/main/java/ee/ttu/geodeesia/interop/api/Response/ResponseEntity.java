package ee.ttu.geodeesia.interop.api.Response;

public class ResponseEntity {
    private Long id;
    private String number;
    private String numberAdditional;
    private String locality;
    private String localityEng;
    private Double latitude;
    private Double longitude;

    private String agent;
    private String GIT;
    private String remarks;
    private Double depth;
    private String mass;

    private String country;
    private String countryEn;

    //specificaly used by locality //TODO:MAYBE realy must be separatly
    private Long stratigraphyBaseId;
    private String stratigraphyBase;
    private String stratigraphBaseEng;

    private Long stratigraphyTopId;
    private String stratigraphyTop;
    private String stratigraphTopEng;

    private Long stratigraphyId;
    private String stratigraphy;
    private String stratigraphyEng;

    //specificaly used by stratigraphy //TODO:MAYBE realy must be separatly
    private String rankValue;
    private String rankValueEng;
    private String scopeValue;
    private String statusValueEng;
    private String indexMain;
    private String indexAdditional;
    private String indexMainHtml;
    private String indexAdditionalHtml;
    private String parentStratigraphy;
    private String parentStratigraphyEng;

    //specificaly used by stratigraphy //TODO:MAYBE realy must be separatly
    private String analysisMethodAnalysisMethod;
    private String analysisMethodMethodEng;
    private String methodDetails;
    private String lab;
    private String instrument;
    private String instrumentTxt;
    private String sample;
    private String date;
    private String dateFree;

    //specifically used by reference
    private String reference;
    private String author;
    private String year;
    private String title;
    private String titleOriginal;
    private String languageValueEng;
    private String journal;
    private String journalName;
    private String journalAdditional;
    private String volume;
    private String book;
    private String pages;
    private String doi;

    //specifically used by images
    private String filename;
    private String dateTaken;
    private String authorAgent;

    //specifically used by specimen
    private String specimenNr;
    private Long localityId;
    private String specimenidentificationName;
    private String specimenidentificationTaxon;
    private String specimenidentificationTaxonAuthorYear;
    private String specimenidentificationTaxonParentTaxon;
    private String specimenidentificationTaxonFossilGroupTaxon;
    private Long lithostratigraphyId;
    private String lithostratigraphyStratigraphy;
    private String lithostratigraphyStratigraphyEng;
    private Long sampleId;

    public String getAnalysisMethodAnalysisMethod() {
        return analysisMethodAnalysisMethod;
    }

    public void setAnalysisMethodAnalysisMethod(String analysisMethodAnalysisMethod) {
        this.analysisMethodAnalysisMethod = analysisMethodAnalysisMethod;
    }

    public String getAnalysisMethodMethodEng() {
        return analysisMethodMethodEng;
    }

    public void setAnalysisMethodMethodEng(String analysisMethodMethodEng) {
        this.analysisMethodMethodEng = analysisMethodMethodEng;
    }

    public String getMethodDetails() {
        return methodDetails;
    }

    public void setMethodDetails(String methodDetails) {
        this.methodDetails = methodDetails;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getInstrumentTxt() {
        return instrumentTxt;
    }

    public void setInstrumentTxt(String instrumentTxt) {
        this.instrumentTxt = instrumentTxt;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateFree() {
        return dateFree;
    }

    public void setDateFree(String dateFree) {
        this.dateFree = dateFree;
    }

    public String getRankValue() {
        return rankValue;
    }

    public void setRankValue(String rankValue) {
        this.rankValue = rankValue;
    }

    public String getRankValueEng() {
        return rankValueEng;
    }

    public void setRankValueEng(String rankValueEng) {
        this.rankValueEng = rankValueEng;
    }

    public String getScopeValue() {
        return scopeValue;
    }

    public void setScopeValue(String scopeValue) {
        this.scopeValue = scopeValue;
    }

    public String getStatusValueEng() {
        return statusValueEng;
    }

    public void setStatusValueEng(String statusValueEng) {
        this.statusValueEng = statusValueEng;
    }

    public String getIndexMain() {
        return indexMain;
    }

    public void setIndexMain(String indexMain) {
        this.indexMain = indexMain;
    }

    public String getIndexAdditional() {
        return indexAdditional;
    }

    public void setIndexAdditional(String indexAdditional) {
        this.indexAdditional = indexAdditional;
    }

    public String getIndexMainHtml() {
        return indexMainHtml;
    }

    public void setIndexMainHtml(String indexMainHtml) {
        this.indexMainHtml = indexMainHtml;
    }

    public String getIndexAdditionalHtml() {
        return indexAdditionalHtml;
    }

    public void setIndexAdditionalHtml(String indexAdditionalHtml) {
        this.indexAdditionalHtml = indexAdditionalHtml;
    }

    public String getParentStratigraphy() {
        return parentStratigraphy;
    }

    public void setParentStratigraphy(String parentStratigraphy) {
        this.parentStratigraphy = parentStratigraphy;
    }

    public String getParentStratigraphyEng() {
        return parentStratigraphyEng;
    }

    public void setParentStratigraphyEng(String parentStratigraphyEng) {
        this.parentStratigraphyEng = parentStratigraphyEng;
    }

    public Long getStratigraphyBaseId() {
        return stratigraphyBaseId;
    }

    public void setStratigraphyBaseId(Long stratigraphyBaseId) {
        this.stratigraphyBaseId = stratigraphyBaseId;
    }

    public String getStratigraphyBase() {
        return stratigraphyBase;
    }

    public void setStratigraphyBase(String stratigraphyBase) {
        this.stratigraphyBase = stratigraphyBase;
    }

    public String getStratigraphBaseEng() {
        return stratigraphBaseEng;
    }

    public void setStratigraphBaseEng(String stratigraphBaseEng) {
        this.stratigraphBaseEng = stratigraphBaseEng;
    }

    public Long getStratigraphyTopId() {
        return stratigraphyTopId;
    }

    public void setStratigraphyTopId(Long stratigraphyTopId) {
        this.stratigraphyTopId = stratigraphyTopId;
    }

    public String getStratigraphyTop() {
        return stratigraphyTop;
    }

    public void setStratigraphyTop(String stratigraphyTop) {
        this.stratigraphyTop = stratigraphyTop;
    }

    public String getStratigraphTopEng() {
        return stratigraphTopEng;
    }

    public void setStratigraphTopEng(String stratigraphTopEng) {
        this.stratigraphTopEng = stratigraphTopEng;
    }

    public Long getStratigraphyId() {
        return stratigraphyId;
    }

    public void setStratigraphyId(Long stratigraphyId) {
        this.stratigraphyId = stratigraphyId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberAdditional() {
        return numberAdditional;
    }

    public void setNumberAdditional(String numberAdditional) {
        this.numberAdditional = numberAdditional;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLocalityEng() {
        return localityEng;
    }

    public void setLocalityEng(String localityEng) {
        this.localityEng = localityEng;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(String stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public String getStratigraphyEng() {
        return stratigraphyEng;
    }

    public void setStratigraphyEng(String stratigraphyEng) {
        this.stratigraphyEng = stratigraphyEng;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getGIT() {
        return GIT;
    }

    public void setGIT(String GIT) {
        this.GIT = GIT;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    //specifically used by reference
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleOriginal() {
        return titleOriginal;
    }

    public void setTitleOriginal(String titleOriginal) {
        this.titleOriginal = titleOriginal;
    }

    public String getLanguageValueEng() {
        return languageValueEng;
    }

    public void setLanguageValueEng(String languageValueEng) {
        this.languageValueEng = languageValueEng;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getJournalAdditional() {
        return journalAdditional;
    }

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

    //specifically used by images
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getAuthorAgent() {
        return authorAgent;
    }

    public void setAuthorAgent(String authorAgent) {
        this.authorAgent = authorAgent;
    }

    //specifically used by specimen
    public String getSpecimenNr() {
        return specimenNr;
    }

    public void setSpecimenNr(String specimenNr) {
        this.specimenNr = specimenNr;
    }

    public Long getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }

    public String getSpecimenidentificationName() {
        return specimenidentificationName;
    }

    public void setSpecimenidentificationName(String specimenidentificationName) {
        this.specimenidentificationName = specimenidentificationName;
    }

    public String getSpecimenidentificationTaxon() {
        return specimenidentificationTaxon;
    }

    public void setSpecimenidentificationTaxon(String specimenidentificationTaxon) {
        this.specimenidentificationTaxon = specimenidentificationTaxon;
    }

    public String getSpecimenidentificationTaxonAuthorYear() {
        return specimenidentificationTaxonAuthorYear;
    }

    public void setSpecimenidentificationTaxonAuthorYear(String specimenidentificationTaxonAuthorYear) {
        this.specimenidentificationTaxonAuthorYear = specimenidentificationTaxonAuthorYear;
    }

    public String getSpecimenidentificationTaxonParentTaxon() {
        return specimenidentificationTaxonParentTaxon;
    }

    public void setSpecimenidentificationTaxonParentTaxon(String specimenidentificationTaxonParentTaxon) {
        this.specimenidentificationTaxonParentTaxon = specimenidentificationTaxonParentTaxon;
    }

    public String getSpecimenidentificationTaxonFossilGroupTaxon() {
        return specimenidentificationTaxonFossilGroupTaxon;
    }

    public void setSpecimenidentificationTaxonFossilGroupTaxon(String specimenidentificationTaxonFossilGroupTaxon) {
        this.specimenidentificationTaxonFossilGroupTaxon = specimenidentificationTaxonFossilGroupTaxon;
    }

    public Long getLithostratigraphyId() {
        return lithostratigraphyId;
    }

    public void setLithostratigraphyId(Long lithostratigraphyId) {
        this.lithostratigraphyId = lithostratigraphyId;
    }

    public String getLithostratigraphyStratigraphy() {
        return lithostratigraphyStratigraphy;
    }

    public void setLithostratigraphyStratigraphy(String lithostratigraphyStratigraphy) {
        this.lithostratigraphyStratigraphy = lithostratigraphyStratigraphy;
    }

    public String getLithostratigraphyStratigraphyEng() {
        return lithostratigraphyStratigraphyEng;
    }

    public void setLithostratigraphyStratigraphyEng(String lithostratigraphyStratigraphyEng) {
        this.lithostratigraphyStratigraphyEng = lithostratigraphyStratigraphyEng;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }
}
