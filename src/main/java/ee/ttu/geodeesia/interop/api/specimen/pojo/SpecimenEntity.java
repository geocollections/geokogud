package ee.ttu.geodeesia.interop.api.specimen.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ConvertableToResponseEntity;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecimenEntity implements Serializable, ConvertableToResponseEntity {
    /*
            "id": 282444,
            "specimen_nr": "152-747",
            "locality_id": 10267,
            "locality__locality": "Kiviõli kraav",
            "locality__locality_en": "Kiviõli trench",
            "specimenidentification__name": "Pseudocrania? sp.",
            "specimenidentification__taxon__taxon": "Pseudocrania",
            "specimenidentification__taxon__author_year": "McCoy, 1851",
            "specimenidentification__taxon__parent__taxon": "Craniidae",
            "specimenidentification__taxon__fossil_group__taxon": "Brachiopoda",
            "stratigraphy_id": 23,
            "stratigraphy__stratigraphy": "Kukruse lade",
            "stratigraphy__stratigraphy_en": "Kukruse Stage",
            "lithostratigraphy_id": null,
            "lithostratigraphy__stratigraphy": null,
            "lithostratigraphy__stratigraphy_en": null,
            "sample_id": null
     */
    @JsonProperty("id")
    private Long id;
    @JsonProperty("specimen_nr")
    private String specimen_nr;
    @JsonProperty("locality_id")
    private Long localityId;
    @JsonProperty("locality__locality")
    private String locality;
    @JsonProperty("locality__locality_en")
    private String localityEng;
    @JsonProperty("specimenidentification__name")
    private String specimenidentificationName;
    @JsonProperty("specimenidentification__taxon__taxon")
    private String specimenidentificationTaxon;
    @JsonProperty("specimenidentification__taxon__author_year")
    private String specimenidentificationTaxonAuthorYear;
    @JsonProperty("specimenidentification__taxon__parent__taxon")
    private String specimenidentificationTaxonParentTaxon;
    @JsonProperty("specimenidentification__taxon__fossil_group__taxon")
    private String specimenidentificationTaxonFossilGroupTaxon;
    @JsonProperty("stratigraphy_id")
    private Long stratigraphyId;
    @JsonProperty("stratigraphy__stratigraphy")
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

    @Override
    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setSpecimenNr(this.specimen_nr);
        response.setLocalityId(this.localityId);
        response.setLocality(this.locality);
        response.setLocalityEng(this.localityEng);
        response.setSpecimenidentificationName(this.specimenidentificationName);
        response.setSpecimenidentificationTaxon(this.specimenidentificationTaxon);
        response.setSpecimenidentificationTaxonAuthorYear(this.specimenidentificationTaxonAuthorYear);
        response.setSpecimenidentificationTaxonParentTaxon(this.specimenidentificationTaxonParentTaxon);
        response.setSpecimenidentificationTaxonFossilGroupTaxon(this.specimenidentificationTaxonFossilGroupTaxon);
        response.setStratigraphyId(this.stratigraphyId);
        response.setStratigraphy(this.stratigraphy);
        response.setStratigraphyEng(this.stratigraphyEng);
        response.setLithostratigraphyId(this.lithostratigraphyId);
        response.setLithostratigraphyStratigraphy(this.lithostratigraphyStratigraphy);
        response.setLithostratigraphyStratigraphyEng(this.lithostratigraphyStratigraphyEng);
        response.setSampleId(this.sampleId);
        return response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecimen_nr() {
        return specimen_nr;
    }

    public void setSpecimen_nr(String specimen_nr) {
        this.specimen_nr = specimen_nr;
    }

    public Long getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
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

    public Long getStratigraphyId() {
        return stratigraphyId;
    }

    public void setStratigraphyId(Long stratigraphyId) {
        this.stratigraphyId = stratigraphyId;
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
