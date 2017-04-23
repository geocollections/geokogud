package ee.ttu.geocollection.indexing;

import java.util.Map;

public interface GlobalSearchApiService {
    Map<String, Object> searchGlobally(String query);
}
