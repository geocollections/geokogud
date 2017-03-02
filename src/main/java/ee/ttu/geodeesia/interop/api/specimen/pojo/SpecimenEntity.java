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
}
