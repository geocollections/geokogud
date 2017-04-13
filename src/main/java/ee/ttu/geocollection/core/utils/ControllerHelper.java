package ee.ttu.geocollection.core.utils;

import ee.ttu.geocollection.domain.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public abstract class ControllerHelper {

    protected Logger logger;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map handleException(Exception ex) {
        if (logger == null) {
            logger = LoggerFactory.getLogger(getClass());
        }
        logger.error("Caught unhandled Error ", ex);
        Map responseMsg = new HashMap();
        responseMsg.put("success", false);
        responseMsg.put("errorCode", HttpStatus.INTERNAL_SERVER_ERROR);
        responseMsg.put("errorDetails", "Unexpected error");

        return responseMsg;
    }

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Map handleCfmException(AppException e, HttpServletResponse response) {
        if (logger != null) {
            logger.warn(e.getErrorCode());
        }
        response.setStatus(e.getStatus().value());
        Map responseMsg = new HashMap();
        responseMsg.put("success", false);
        responseMsg.put("errorCode", e.getErrorCode());
        String errorDetails = e.getErrorDetails();
        if (errorDetails != null) {
            responseMsg.put("errorDetails", errorDetails);
        }
        return responseMsg;
    }

}
