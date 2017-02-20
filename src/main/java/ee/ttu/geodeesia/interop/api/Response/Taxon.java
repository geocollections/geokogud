package ee.ttu.geodeesia.interop.api.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 48707222248 on 18.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Taxon {

    @JsonProperty("author_year")
    private String authorYear;

    @JsonProperty("date_changed")
    private String dateChanged;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("taxon")
    private String taxon;

    //more params can be shown
    //fossil_group__id, in_baltoscandia,in_estonia, is_valid, parent__taxon, parent_id,
    // rank__rank,rank__rank_en,stratigraphy_base__stratigraphy,stratigraphy_top__stratigraphy_en,
    //stratigraphy_top_id,synonym_of, synonym_of_reference_id, taxon_epithet


    public String getAuthorYear() {
        return authorYear;
    }

    public void setAuthorYear(String authorYear) {
        this.authorYear = authorYear;
    }

    public String getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTaxon() {
        return taxon;
    }

    public void setTaxon(String taxon) {
        this.taxon = taxon;
    }
}
