package ee.ttu.geocollection.interop.api.localities.pojo;

import java.util.List;

public class LocalityMapFilter {
    private List<String> filters;
    private String localityName;

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }
}
