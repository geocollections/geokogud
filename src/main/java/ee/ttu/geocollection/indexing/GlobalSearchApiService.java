package ee.ttu.geocollection.indexing;

import org.springframework.context.annotation.Profile;

import java.util.Map;

import static ee.ttu.geocollection.EnvironmentConstants.PRODUCTION;

@Profile(PRODUCTION)
public interface GlobalSearchApiService {
    Map<String, Object> searchGlobally(String query);
}
