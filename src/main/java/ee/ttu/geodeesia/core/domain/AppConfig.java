package ee.ttu.geodeesia.core.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("appConfig")
public class AppConfig {

    @Value("${ermas.url}")
    public String ermasUrl;

    @Value("${fossils.url}")
    public String fossilsUrl;

    @Value("${geo-api.url}")
    public String apiUrl;
    
    @Value("${tug.url}")
    public String tugUrl;
    
    @Value("${elm.url}")
    public String elmUrl;
    
    @Value("${geocase.url}")
    public String geocaseUrl;
    
    @Value("${github.url}")
    public String githubUrl;

}
