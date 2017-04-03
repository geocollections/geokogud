package ee.ttu.geocollection.core.controller;

import ee.ttu.geocollection.core.domain.ClientSideError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logger")
public class LoggingController {
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping(method= RequestMethod.POST)
    public void logError(ClientSideError error){
        logger.info("Client side error: \n"
                + "Message: " + error.getMessage() + "\n"
                + "Url: " + error.getUrl() + "\n"
                + error.getStackTrace());
    }
}
