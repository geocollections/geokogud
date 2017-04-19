package ee.ttu.geocollection.domain;

import java.util.Arrays;
import java.util.List;

public enum LookUpType {
    exact,      //vxrdub
    iexact,     //vxrdub case insensitive
    in,         //sisaldub loetelus
    range,      //vahemikus
    contains,   //sisaldab
    icontains,  //sisaldab case insensitive
    startswith, //algab
    istartswith,//algab case insensitive
    endswith,   //lxpeb
    iendswith,  //lxpeb case insensitive
    gt,         //suurem kui
    lt,         //vaiksem kui
    gte,        //suurem v6i v6rdne kui
    lte,        //vaiksem v6i v6rdne kui
    isnull,
    hierarchy,
    //API-s non defined values
    doesnotcontain,
    doesnotexact,
    ;

    public String value() {
        if(this.equals(LookUpType.doesnotcontain)) return "icontains !";
        else if(this.equals(LookUpType.doesnotexact)) return "iexact !";
        return name();
    }

    public static LookUpType fromValue(String v) {
        return valueOf(v);
    }

    public static List<LookUpType> getTextFieldLookUpTypes() {
        return Arrays.asList(contains,exact,startswith,endswith,icontains,in);
    }
}