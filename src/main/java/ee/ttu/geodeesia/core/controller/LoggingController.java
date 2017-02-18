package ee.ttu.geodeesia.core.controller;

import ee.ttu.geodeesia.core.domain.ClientSideError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 48707222248 on 18.02.2017.
 */
@Controller
@RequestMapping("/logger")
public class LoggingController {
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public void logError(@RequestBody ClientSideError error){
        logger.info("Client side error: \n"
                + "Message: " + error.getMessage() + "\n"
                + "Url: " + error.getUrl() + "\n"
                + error.getStackTrace());
    }
}
