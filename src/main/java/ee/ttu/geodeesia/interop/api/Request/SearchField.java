package ee.ttu.geodeesia.interop.api.Request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 48707222248 on 21.02.2017.
 */
public class SearchField {

    private String name;

    @Enumerated(EnumType.STRING)
    private LookUpType lookUpType;



    public enum LookUpType {
        exact,      //vxrdub
        iexact,     //ei vxrdu
        in,         //sisaldub loetelus
        range,      //vahemikus
        contains,   //sisaldab
        icontains,  //ei sisalda
        startswith, //algab
        istartswith,//ei alga
        endswith,   //lxpeb
        iendswith,  //ei lxpe
        gt,         //suurem kui
        lt,         //vaiksem kui
        gte,        //suurem v6i v6rdne kui
        lte,        //vaiksem v6i v6rdne kui
        isnull,
        hierarchy;

        public String value() {
            return name();
        }

        public static LookUpType fromValue(String v) {
            return valueOf(v);
        }

        public static List<LookUpType> getTextFieldLookUpTypes() {
            return Arrays.asList(contains,exact,startswith,endswith,icontains,in);
        }
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
