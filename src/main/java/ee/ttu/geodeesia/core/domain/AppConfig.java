package ee.ttu.geodeesia.core.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 48707222248 on 18.02.2017.
 */
@Component("appConfig")
public class AppConfig {

    @Value("${ermas.url}")
    public String ermasUrl;

    @Value("${fossils.url}")
    public String fossilsUrl;

}
