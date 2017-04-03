package ee.ttu.geocollection.interop.api.preparations.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Olesja Senkiv on 27.03.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Preparation {

/*    "id": 1,
            "sample_id": 281,
            "preparation_number": "M-349",
            "sample__locality__locality": "Paluküla 3 puurauk",
            "sample__locality__locality_en": "Paluküla 3 borehole",
            "sample__depth": 17.95,
            "sample__depth_interval": 17.97,
            "sample__agent_collected__agent": null,
            "sample__agent_collected__forename": null,
            "sample__agent_collected__surename": null,
            "sample__agent_collected_free": null,
            "sample__stratigraphy__stratigraphy": "Rakvere lade",
            "sample__stratigraphy__stratigraphy_en": "Rakvere Stage",
            "sample__stratigraphy_free": null,
            "sample__lithostratigraphy__stratigraphy": null,
            "sample__lithostratigraphy__stratigraphy_en": null,
            "classification__class_field": null,
            "classification__class_en": null,
            "location": null,
            "storage__location": null,
            "storage__location_location": null,
            "date_added": null,
            "date_changed": null,
            "user_added": "olle",
            "user_changed": null
*/
    @JsonProperty("id")
    private Long id;
    private Long sampleId;
    private String number;
    private String sampleLocality;
    private String sampleLocalityEn;
    private String sampleDepth;
    private String sampleDepthInterval;
    private String sampleAgentCollected;
    private String sampleAgentCollectedForename;
    private String sampleAgentCollectedSurename;
    private String sampleAgentCollectedFree;
    private String sampleStratigraphy;
    private String sampleStratigraphyEn;
    private String sampleStratigraphyFree;
    private String sampleLithostratigraphyStratigraphy;
    private String sampleLithostratigraphyStratigraphyEn;
    private String classificationClassField;
    private String classificationClassEn;
    @JsonProperty("location")
    private String location;
    private String storageLocation;
    private String storageLocationLocation;
    private String dateAdded;
    private String dateChanged;
    private String userAdded;
    private String userChanged;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonProperty("sampleId")
    public Long getSampleId() {
        return sampleId;
    }
    @JsonProperty("sample_id")
    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }
    @JsonProperty("number")
    public String getNumber() {
        return number;
    }
    @JsonProperty("preparation_number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("sampleLocality")
    public String getSampleLocality() {
        return sampleLocality;
    }
    @JsonProperty("sample__locality__locality")
    public void setSampleLocality(String sampleLocality) {
        this.sampleLocality = sampleLocality;
    }
    @JsonProperty("sampleLocalityEn")
    public String getSampleLocalityEn() {
        return sampleLocalityEn;
    }
    @JsonProperty("sample__locality__locality_en")
    public void setSampleLocalityEn(String sampleLocalityEn) {
        this.sampleLocalityEn = sampleLocalityEn;
    }
    @JsonProperty("sampleDepth")
    public String getSampleDepth() {
        return sampleDepth;
    }
    @JsonProperty("sample__depth")
    public void setSampleDepth(String sampleDepth) {
        this.sampleDepth = sampleDepth;
    }
    @JsonProperty("sampleDepthInterval")
    public String getSampleDepthInterval() {
        return sampleDepthInterval;
    }
    @JsonProperty("sample__depth_interval")
    public void setSampleDepthInterval(String sampleDepthInterval) {
        this.sampleDepthInterval = sampleDepthInterval;
    }
    @JsonProperty("sampleAgentCollected")
    public String getSampleAgentCollected() {
        return sampleAgentCollected;
    }
    @JsonProperty("sample__agent_collected__agent")
    public void setSampleAgentCollected(String sampleAgentCollected) {
        this.sampleAgentCollected = sampleAgentCollected;
    }
    @JsonProperty("sampleAgentCollectedForename")
    public String getSampleAgentCollectedForename() {
        return sampleAgentCollectedForename;
    }
    @JsonProperty("sample__agent_collected__forename")
    public void setSampleAgentCollectedForename(String sampleAgentCollectedForename) {
        this.sampleAgentCollectedForename = sampleAgentCollectedForename;
    }
    @JsonProperty("sampleAgentCollectedSurename")
    public String getSampleAgentCollectedSurename() {
        return sampleAgentCollectedSurename;
    }
    @JsonProperty("sample__agent_collected__surename")
    public void setSampleAgentCollectedSurename(String sampleAgentCollectedSurename) {
        this.sampleAgentCollectedSurename = sampleAgentCollectedSurename;
    }
    @JsonProperty("sampleAgentCollectedFree")
    public String getSampleAgentCollectedFree() {
        return sampleAgentCollectedFree;
    }
    @JsonProperty("sample__agent_collected_free")
    public void setSampleAgentCollectedFree(String sampleAgentCollectedFree) {
        this.sampleAgentCollectedFree = sampleAgentCollectedFree;
    }
    @JsonProperty("sampleStratigraphy")
    public String getSampleStratigraphy() {
        return sampleStratigraphy;
    }
    @JsonProperty("sample__stratigraphy__stratigraphy")
    public void setSampleStratigraphy(String sampleStratigraphy) {
        this.sampleStratigraphy = sampleStratigraphy;
    }
    @JsonProperty("sampleStratigraphyEn")
    public String getSampleStratigraphyEn() {
        return sampleStratigraphyEn;
    }
    @JsonProperty("sample__stratigraphy__stratigraphy_en")
    public void setSampleStratigraphyEn(String sampleStratigraphyEn) {
        this.sampleStratigraphyEn = sampleStratigraphyEn;
    }
    @JsonProperty("sampleStratigraphyFree")
    public String getSampleStratigraphyFree() {
        return sampleStratigraphyFree;
    }
    @JsonProperty("sample__stratigraphy_free")
    public void setSampleStratigraphyFree(String sampleStratigraphyFree) {
        this.sampleStratigraphyFree = sampleStratigraphyFree;
    }
    @JsonProperty("sampleLithostratigraphyStratigraphy")
    public String getSampleLithostratigraphyStratigraphy() {
        return sampleLithostratigraphyStratigraphy;
    }
    @JsonProperty("sample__lithostratigraphy__stratigraphy")
    public void setSampleLithostratigraphyStratigraphy(String sampleLithostratigraphyStratigraphy) {
        this.sampleLithostratigraphyStratigraphy = sampleLithostratigraphyStratigraphy;
    }
    @JsonProperty("sampleLithostratigraphyStratigraphyEn")
    public String getSampleLithostratigraphyStratigraphyEn() {
        return sampleLithostratigraphyStratigraphyEn;
    }
    @JsonProperty("sample__lithostratigraphy__stratigraphy_en")
    public void setSampleLithostratigraphyStratigraphyEn(String sampleLithostratigraphyStratigraphyEn) {
        this.sampleLithostratigraphyStratigraphyEn = sampleLithostratigraphyStratigraphyEn;
    }
    @JsonProperty("classificationClassField")
    public String getClassificationClassField() {
        return classificationClassField;
    }
    @JsonProperty("classification__class_field")
    public void setClassificationClassField(String classificationClassField) {
        this.classificationClassField = classificationClassField;
    }
    @JsonProperty("classificationClassEn")
    public String getClassificationClassEn() {
        return classificationClassEn;
    }
    @JsonProperty("classification__class_en")
    public void setClassificationClassEn(String classificationClassEn) {
        this.classificationClassEn = classificationClassEn;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @JsonProperty("storageLocation")
    public String getStorageLocation() {
        return storageLocation;
    }
    @JsonProperty("storage__location")
    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
    @JsonProperty("storageLocationLocation")
    public String getStorageLocationLocation() {
        return storageLocationLocation;
    }
    @JsonProperty("storage__location_location")
    public void setStorageLocationLocation(String storageLocationLocation) {
        this.storageLocationLocation = storageLocationLocation;
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
    @JsonProperty("userAdded")
    public String getUserAdded() {
        return userAdded;
    }
    @JsonProperty("user_added")
    public void setUserAdded(String userAdded) {
        this.userAdded = userAdded;
    }
    @JsonProperty("userChanged")
    public String getUserChanged() {
        return userChanged;
    }
    @JsonProperty("user_changed")
    public void setUserChanged(String userChanged) {
        this.userChanged = userChanged;
    }
}
