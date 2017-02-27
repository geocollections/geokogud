package ee.ttu.geodeesia.search.domain;

import ee.ttu.geodeesia.interop.api.samples.pojo.SampleSearch;

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
