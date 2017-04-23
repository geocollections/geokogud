package ee.ttu.geocollection.indexing.impl;

import ee.ttu.geocollection.indexing.GlobalSearchApiService;
import ee.ttu.geocollection.interop.api.specimen.service.SpecimenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;

import static ee.ttu.geocollection.EnvironmentConstants.PRODUCTION;

@Service
@Profile(PRODUCTION)
public class GlobalSearchApiServiceImpl implements GlobalSearchApiService {
    private static final String NUMBER_REGEX = "\\d+";

    @Autowired
    private SpecimenApiService specimenApiService;

    @Override
    public Map<String, Object> searchGlobally(String query) {
        if (isNumber(query)) {

        }
        return null;
    }

    private boolean isNumber(String query) {
        return query.matches(NUMBER_REGEX);
    }

}
