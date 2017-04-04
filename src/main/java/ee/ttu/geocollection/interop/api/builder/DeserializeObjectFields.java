package ee.ttu.geocollection.interop.api.builder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeserializeObjectFields {
    private Set<String> fullFields = new HashSet<>();
    private Map<String, String> cutFields = new HashMap<>();

    public DeserializeObjectFields(Set<String> fullFields, Map<String, String> cutFields) {
        this.fullFields = fullFields;
        this.cutFields = cutFields;
    }

    public Set<String> getFullFields() {
        return fullFields;
    }

    public Map<String, String> getCutFields() {
        return cutFields;
    }
}