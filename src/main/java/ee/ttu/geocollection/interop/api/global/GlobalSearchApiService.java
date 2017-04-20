package ee.ttu.geocollection.interop.api.global;

import java.util.Map;

public interface GlobalSearchApiService {
    Map<String, Object> searchGlobally(String query);
}
