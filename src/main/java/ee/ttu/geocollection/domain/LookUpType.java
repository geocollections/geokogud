package ee.ttu.geocollection.domain;

import java.util.Arrays;
import java.util.List;

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