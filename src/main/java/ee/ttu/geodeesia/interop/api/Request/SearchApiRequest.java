package ee.ttu.geodeesia.interop.api.Request;

/**
 * Created by 48707222248 on 18.02.2017.
 */
public class SearchApiRequest {
    private String outputFormat = "json";
    private int page;
    private int numberOfRecordsPerPage;
    private String searchCriteria;
    private String field;
    private String fieldsParams;

    public String getFieldsParams() {
        return fieldsParams;
    }

    public void setFieldsParams(String fieldsParams) {
        this.fieldsParams = fieldsParams;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public int getPage() {
        return page;
    }

    public int getNumberOfRecordsPerPage() {
        return numberOfRecordsPerPage;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setNumberOfRecordsPerPage(int numberOfRecordsPerPage) {
        this.numberOfRecordsPerPage = numberOfRecordsPerPage;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
