package ee.ttu.geodeesia.interop.api.Request;

public class SearchApiRequest {
    private String outputFormat = "json";
    private int page;
    private int numberOfRecordsPerPage = 30;
    //TODO:remove
    private String searchCriteria;
    //TODO:remove
    private String field;
    private String fieldsParams;
    private String table;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

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
