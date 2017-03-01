package ee.ttu.geodeesia.interop.api.analyses.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.ttu.geodeesia.interop.api.Response.ResponseEntity;

import java.io.Serializable;

/**
 * Created by Olesja Senkiv on 28.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysesEntity implements Serializable {
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
    @JsonProperty("analysis_method__analysis_method")
    private String analysisMethodAnalysisMethod;
    @JsonProperty("analysis_method__method_en")
    private String analysisMethodMethodEn;
    @JsonProperty("method_details")
    private String methodDetails;
    @JsonProperty("lab")
    private String lab;
    @JsonProperty("instrument")
    private String instrument;
    @JsonProperty("instrument_txt")
    private String instrumentTxt;
    @JsonProperty("sample")
    private String sample;
    @JsonProperty("date")
    private String date;
    @JsonProperty("date_free")
    private String dateFree;

    public ResponseEntity toResponse() {
        ResponseEntity response = new ResponseEntity();
        response.setId(this.id);
        response.setAnalysisMethodAnalysisMethod(this.analysisMethodAnalysisMethod);
        response.setAnalysisMethodMethodEn(this.analysisMethodMethodEn);
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
