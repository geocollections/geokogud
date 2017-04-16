package ee.ttu.geocollection.core.controller;

import ee.ttu.geocollection.core.domain.ClientSideError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/error")
public class ErrorController {

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
