package ee.ttu.geodeesia.interop.api.Response;

public class ResponseEntity {
    private Long id;
    private String number;
    private String numberAdditional;
    private String locality;
    private String localityEn;
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
    private String rankValueEn;
    private String scopeValue;
    private String statusValueEn;
    private String indexMain;
    private String indexAdditional;
    private String indexMainHtml;
    private String indexAdditionalHtml;
    private String parentStratigraphy;
    private String parentStratigraphyEn;

    //specificaly used by stratigraphy //TODO:MAYBE realy must be separatly
    private String analysisMethodAnalysisMethod;
    private String analysisMethodMethodEn;
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
    private String title_original;
    private String language__value_en;
    private String journal;
    private String journal__journal_name;
    private String journal_additional;
    private String volume;
    private String book;
    private String pages;
    private String doi;


    public String getAnalysisMethodAnalysisMethod() {
        return analysisMethodAnalysisMethod;
    }

    public void setAnalysisMethodAnalysisMethod(String analysisMethodAnalysisMethod) {
        this.analysisMethodAnalysisMethod = analysisMethodAnalysisMethod;
    }

    public String getAnalysisMethodMethodEn() {
        return analysisMethodMethodEn;
    }

    public void setAnalysisMethodMethodEn(String analysisMethodMethodEn) {
        this.analysisMethodMethodEn = analysisMethodMethodEn;
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

    public String getRankValueEn() {
        return rankValueEn;
    }

    public void setRankValueEn(String rankValueEn) {
        this.rankValueEn = rankValueEn;
    }

    public String getScopeValue() {
        return scopeValue;
    }

    public void setScopeValue(String scopeValue) {
        this.scopeValue = scopeValue;
    }

    public String getStatusValueEn() {
        return statusValueEn;
    }

    public void setStatusValueEn(String statusValueEn) {
        this.statusValueEn = statusValueEn;
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

    public String getParentStratigraphyEn() {
        return parentStratigraphyEn;
    }

    public void setParentStratigraphyEn(String parentStratigraphyEn) {
        this.parentStratigraphyEn = parentStratigraphyEn;
    }

    public Long getStratigraphyBaseId() {
        return stratigraphyBaseId;
    }
    public void setStratigraphyBaseId(Long stratigraphyBaseId) {
        this.stratigraphyBaseId = stratigraphyBaseId;
    }

    public void setStratigraphyTopId(Long stratigraphyTopId) {
        this.stratigraphyTopId = stratigraphyTopId;
    }

    public void setStratigraphyId(Long stratigraphyId) {
        this.stratigraphyId = stratigraphyId;
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

    public String getNumber() {
        return number;
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

    public String getLocalityEn() {
        return localityEn;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getStratigraphy() {
        return stratigraphy;
    }

    public String getStratigraphyEng() {
        return stratigraphyEng;
    }

    public String getAgent() {
        return agent;
    }

    public String getGIT() {
        return GIT;
    }

    public String getRemarks() {
        return remarks;
    }

    public Double getDepth() {
        return depth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setLocalityEn(String localityEn) {
        this.localityEn = localityEn;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setStratigraphy(String stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public void setStratigraphyEng(String stratigraphyEng) {
        this.stratigraphyEng = stratigraphyEng;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setGIT(String GIT) {
        this.GIT = GIT;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getTitle_original() {
        return title_original;
    }

    public void setTitle_original(String title_original) {
        this.title_original = title_original;
    }

    public String getLanguage__value_en() {
        return language__value_en;
    }

    public void setLanguage__value_en(String language__value_en) {
        this.language__value_en = language__value_en;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getJournal__journal_name() {
        return journal__journal_name;
    }

    public void setJournal__journal_name(String journal__journal_name) {
        this.journal__journal_name = journal__journal_name;
    }

    public String getJournal_additional() {
        return journal_additional;
    }

    public void setJournal_additional(String journal_additional) {
        this.journal_additional = journal_additional;
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

    public void setDoi(String doi) { this.doi = doi; }
}
