package generator;

import java.util.ArrayList;
import java.util.List;

public class GeneratorObjectFields {
    private List<String> fullFields = new ArrayList<>();
    private List<String> cutFields = new ArrayList<>();

    public GeneratorObjectFields(List<String> fullFields, List<String> cutFields) {
        this.fullFields = fullFields;
        this.cutFields = cutFields;
    }

    public List<String> getFullFields() {
        return fullFields;
    }

    public List<String> getCutFields() {
        return cutFields;
    }
}
