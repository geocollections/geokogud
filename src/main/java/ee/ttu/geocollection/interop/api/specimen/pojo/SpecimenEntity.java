package ee.ttu.geocollection.interop.api.specimen.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecimenEntity {
    @JsonProperty("id")
    private Long id;
    private String specimenNr;
    @JsonProperty("locality_id")
    private Long localityId;
    private String locality;
    @JsonProperty("locality__locality_en")
    private String localityEng;
    private String specimenidentificationName;
    private String taxon;
    @JsonProperty("specimenidentification__taxon__author_year")
    private String specimenidentificationTaxonAuthorYear;
    @JsonProperty("specimenidentification__taxon__parent__taxon")
    private String specimenidentificationTaxonParentTaxon;
    @JsonProperty("specimenidentification__taxon__fossil_group__taxon")
    private String specimenidentificationTaxonFossilGroupTaxon;
    @JsonProperty("stratigraphy_id")
    private Long stratigraphyId;
    private String stratigraphy;
    @JsonProperty("stratigraphy__stratigraphy_en")
    private String stratigraphyEng;
    @JsonProperty("lithostratigraphy_id")
    private Long lithostratigraphyId;
    @JsonProperty("lithostratigraphy__stratigraphy")
    private String lithostratigraphyStratigraphy;
    @JsonProperty("lithostratigraphy__stratigraphy_en")
    private String lithostratigraphyStratigraphyEng;
    @JsonProperty("sample_id")
    private Long sampleId;
    private String classification;
    private String depth;

    @JsonProperty("classification")
    public String getClassification() {
        return classification;
    }

    @JsonProperty("classification__class_field")
    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("specimenNr")
    public String getSpecimenNr() {
        return specimenNr;
    }

    @JsonProperty("specimen_nr")
    public void setSpecimenNr(String specimenNr) {
        this.specimenNr = specimenNr;
    }

    public Long getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }

    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }

    @JsonProperty("locality__locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLocalityEng() {
        return localityEng;
    }

    public void setLocalityEng(String localityEng) {
        this.localityEng = localityEng;
    }

    @JsonProperty("specimenIdentificationName")
    public String getSpecimenidentificationName() {
        return specimenidentificationName;
    }

    @JsonProperty("specimenidentification__name")
    public void setSpecimenidentificationName(String specimenidentificationName) {
        this.specimenidentificationName = specimenidentificationName;
    }

    @JsonProperty("taxon")
    public String getTaxon() {
        return taxon;
    }

    @JsonProperty("specimenidentification__taxon__taxon")
    public void setTaxon(String taxon) {
        this.taxon = taxon;
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

    public Long getStratigraphyId() {
        return stratigraphyId;
    }

    public void setStratigraphyId(Long stratigraphyId) {
        this.stratigraphyId = stratigraphyId;
    }

    @JsonProperty("stratigraphy")
    public String getStratigraphy() {
        return stratigraphy;
    }

    @JsonProperty("stratigraphy__stratigraphy")
    public void setStratigraphy(String stratigraphy) {
        this.stratigraphy = stratigraphy;
    }

    public String getStratigraphyEng() {
        return stratigraphyEng;
    }

    public void setStratigraphyEng(String stratigraphyEng) {
        this.stratigraphyEng = stratigraphyEng;
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
