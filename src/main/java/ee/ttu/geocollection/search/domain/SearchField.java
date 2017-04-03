package ee.ttu.geocollection.search.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SearchField {

    private String name;

    @Enumerated(EnumType.STRING)
    private LookUpType lookUpType;

    public SearchField() {
    }

    public SearchField(String name,LookUpType lookUpType) {
        this.name = name;
        this.lookUpType = lookUpType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LookUpType getLookUpType() {
        return lookUpType;
    }

    public void setLookUpType(LookUpType lookUpType) {
        this.lookUpType = lookUpType;
    }
}
