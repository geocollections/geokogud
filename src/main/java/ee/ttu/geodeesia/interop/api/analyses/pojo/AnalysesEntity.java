package ee.ttu.geodeesia.interop.api.analyses.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ConvertableToResponseEntity;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysesEntity implements Serializable, ConvertableToResponseEntity {
    private static final long serialVersionUID = 1L;
/*
    {"id":1,
    "analysis_method__analysis_method":"granulomeetria",
    "analysis_method__method_en":"granulometry",
    "method_details":"",
    "lab":null,
    "instrument":null,
    "instrument_txt":null,
    "sample":28257,
    "date":null,
    "date_free":null
    }*/
    @JsonProperty("id")
    private Long id;

    private String analysisMethodAnalysisMethod;

    private String analysisMethodMethodEn;

    private String methodDetails;
    @JsonProperty("lab")
    private String lab;
    @JsonProperty("instrument")
    private String instrument;

    private String instrumentTxt;
    @JsonProperty("sample")
    private String sample;
    @JsonProperty("date")
    private String date;

    private String dateFree;

    @JsonProperty("analysisMethodAnalysisMethod")
    public String getAnalysisMethodAnalysisMethod() {
        return analysisMethodAnalysisMethod;
    }
    @JsonProperty("analysis_method__analysis_method")
    public void setAnalysisMethodAnalysisMethod(String analysisMethodAnalysisMethod) {
        this.analysisMethodAnalysisMethod = analysisMethodAnalysisMethod;
    }
    @JsonProperty("analysisMethodMethodEn")
    public String getAnalysisMethodMethodEn() {
        return analysisMethodMethodEn;
    }
    @JsonProperty("analysis_method__method_en")
    public void setAnalysisMethodMethodEn(String analysisMethodMethodEn) {
        this.analysisMethodMethodEn = analysisMethodMethodEn;
    }
    @JsonProperty("methodDetails")
    public String getMethodDetails() {
        return methodDetails;
    }
    @JsonProperty("method_details")
    public void setMethodDetails(String methodDetails) {
        this.methodDetails = methodDetails;
    }
    @JsonProperty("instrumentTxt")
    public String getInstrumentTxt() {
        return instrumentTxt;
    }
    @JsonProperty("instrument_txt")
    public void setInstrumentTxt(String instrumentTxt) {
        this.instrumentTxt = instrumentTxt;
    }
    @JsonProperty("dateFree")
    public String getDateFree() {
        return dateFree;
    }
    @JsonProperty("date_free")
    public void setDateFree(String dateFree) {
        this.dateFree = dateFree;
    }

    @Override
    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setAnalysisMethodAnalysisMethod(this.analysisMethodAnalysisMethod);
        response.setAnalysisMethodMethodEng(this.analysisMethodMethodEn);
        response.setMethodDetails(this.methodDetails);
        response.setLab(this.lab);
        response.setInstrument(this.instrument);
        response.setInstrumentTxt(this.instrumentTxt);
        response.setSample(this.sample);
        response.setDate(this.date);
        response.setDateFree(this.dateFree);
        return response;
    }

}
