package ee.ttu.geodeesia.interop.api.specimen.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecimenEntity {
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
    private Long locality_id;
    @JsonProperty("locality__locality")
    private String locality__locality;
    @JsonProperty("locality__locality_en")
    private String locality__locality_en;
    @JsonProperty("specimenidentification__name")
    private String specimenidentification__name;
    @JsonProperty("specimenidentification__taxon__taxon")
    private String specimenidentification__taxon__taxon;
    @JsonProperty("specimenidentification__taxon__author_year")
    private String specimenidentification__taxon__author_year;
    @JsonProperty("specimenidentification__taxon__parent__taxon")
    private String specimenidentification__taxon__parent__taxon;
    @JsonProperty("specimenidentification__taxon__fossil_group__taxon")
    private String specimenidentification__taxon__fossil_group__taxon;
    @JsonProperty("stratigraphy_id")
    private Long stratigraphy_id;
    @JsonProperty("stratigraphy__stratigraphy")
    private String stratigraphy__stratigraphy;
    @JsonProperty("stratigraphy__stratigraphy_en")
    private String stratigraphy__stratigraphy_en;
    @JsonProperty("lithostratigraphy_id")
    private Long lithostratigraphy_id;
    @JsonProperty("lithostratigraphy__stratigraphy")
    private String lithostratigraphy__stratigraphy;
    @JsonProperty("lithostratigraphy__stratigraphy_en")
    private String lithostratigraphy__stratigraphy_en;
    @JsonProperty("sample_id")
    private Long sample_id;

    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setSpecimen_nr(this.specimen_nr);
        response.setLocality_id(this.locality_id);
        response.setLocality__locality(this.locality__locality);
        response.setLocality__locality_en(this.locality__locality_en);
        response.setSpecimenidentification__name(this.specimenidentification__name);
        response.setSpecimenidentification__taxon__taxon(this.specimenidentification__taxon__taxon);
        response.setSpecimenidentification__taxon__author_year(this.specimenidentification__taxon__author_year);
        response.setSpecimenidentification__taxon__parent__taxon(this.specimenidentification__taxon__parent__taxon);
        response.setSpecimenidentification__taxon__fossil_group__taxon(this.specimenidentification__taxon__fossil_group__taxon);
        response.setStratigraphy_id(this.stratigraphy_id);
        response.setStratigraphy__stratigraphy(this.stratigraphy__stratigraphy);
        response.setStratigraphy__stratigraphy_en(this.stratigraphy__stratigraphy_en);
        response.setLithostratigraphy_id(this.lithostratigraphy_id);
        response.setLithostratigraphy__stratigraphy(this.lithostratigraphy__stratigraphy);
        response.setLithostratigraphy__stratigraphy_en(this.lithostratigraphy__stratigraphy_en);
        response.setSample_id(this.sample_id);
        return response;
    }
}
