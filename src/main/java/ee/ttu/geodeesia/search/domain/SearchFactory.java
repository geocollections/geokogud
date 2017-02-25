package ee.ttu.geodeesia.search.domain;

/**
 * Created by 48707222248 on 21.02.2017.
 */
public class SearchFactory {
    public static AbstractSearch create(String searchName) {
        AbstractSearch search = null;
        switch (searchName) {
            case "SPECIMENTS":
                search = new SampleSearch(searchName);
                break;
            case "SAMPLES":
                search = new SampleSearch(searchName);
                break;
            default: break;
        }

        return search;
    }
}
