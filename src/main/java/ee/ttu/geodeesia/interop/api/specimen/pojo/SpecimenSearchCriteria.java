package ee.ttu.geodeesia.interop.api.specimen.pojo;

import ee.ttu.geodeesia.search.domain.SearchField;
import ee.ttu.geodeesia.search.domain.SortField;

public class SpecimenSearchCriteria {
    private int page = 1;
    private SortField sortField;

    private SearchField id;
    private SearchField specimenNumber;
    private SearchField collectionNumber;
    private SearchField classification;
    private SearchField fossilMineralRock;
    private SearchField fossilName;
    private SearchField mineralRock;
    private SearchField adminUnit;
    private SearchField locality;
    private SearchField depth;
    private SearchField stratigraphy;
    private SearchField collector;
    private SearchField reference;
    private SearchField typeStatus;
    private SearchField partOfFossil;
    private SearchField keyWords;
    private SearchField regDate;

    public SearchField getId() {
        return id;
    }

    public void setId(SearchField id) {
        this.id = id;
    }

    public SearchField getSpecimenNumber() {
        return specimenNumber;
    }

    public void setSpecimenNumber(SearchField specimenNumber) {
        this.specimenNumber = specimenNumber;
    }

    public SearchField getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(SearchField collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public SearchField getClassification() {
        return classification;
    }

    public void setClassification(SearchField classification) {
        this.classification = classification;
    }

    public SearchField getFossilMineralRock() {
        return fossilMineralRock;
    }

    public void setFossilMineralRock(SearchField fossilMineralRock) {
        this.fossilMineralRock = fossilMineralRock;
    }

    public SearchField getFossilName() {
        return fossilName;
    }

    public void setFossilName(SearchField fossilName) {
        this.fossilName = fossilName;
    }

    public SearchField getMineralRock() {
        return mineralRock;
    }

    public void setMineralRock(SearchField mineralRock) {
        this.mineralRock = mineralRock;
    }

    public SearchField getAdminUnit() {
        return adminUnit;
    }

    public void setAdminUnit(SearchField adminUnit) {
        this.adminUnit = adminUnit;
    }

    public SearchField getLocality() {
        return locality;
    }

    public void setLocality(SearchField locality) {
        this.locality = locality;
    }

    public SearchField getDepth() {
        return depth;
    }

    public void setDepth(SearchField depth) {
        this.depth = depth;
    }

    public SearchField getStratigraphy() {
        return stratigraphy;
    }

    public void setStratigraphy(SearchField stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public SearchField getCollector() {
        return collector;
    }

    public void setCollector(SearchField collector) {
        this.collector = collector;
    }

    public SearchField getReference() {
        return reference;
    }

    public void setReference(SearchField reference) {
        this.reference = reference;
    }

    public SearchField getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(SearchField typeStatus) {
        this.typeStatus = typeStatus;
    }

    public SearchField getPartOfFossil() {
        return partOfFossil;
    }

    public void setPartOfFossil(SearchField partOfFossil) {
        this.partOfFossil = partOfFossil;
    }

    public SearchField getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(SearchField keyWords) {
        this.keyWords = keyWords;
    }

    public SearchField getRegDate() {
        return regDate;
    }

    public void setRegDate(SearchField regDate) {
        this.regDate = regDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
    }
}
