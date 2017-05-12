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
import java.util.Optional;

public abstract class ControllerHelper {

    private static final Logger logger = LoggerFactory.getLogger(ControllerHelper.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map handleException(Exception ex) {
        logger.error("Caught unhandled Error ", ex);
        Map<String, String> responseMsg = new HashMap<>();
        responseMsg.put("success", String.valueOf(false));
        responseMsg.put("errorCode", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        responseMsg.put("errorDetails", "Unexpected error");

        return responseMsg;
    }

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Map handleCfmException(AppException e, HttpServletResponse response) {
        logger.error("AppException", e);
        response.setStatus(e.getStatus().value());
        Map<String, String> responseMsg = new HashMap<>();
        responseMsg.put("success", String.valueOf(false));
        responseMsg.put("errorCode", e.getErrorCode());
        Optional.ofNullable(e.getErrorDetails())
                .ifPresent(errorDetails -> responseMsg.put("errorDetails", errorDetails));
        return responseMsg;
    }

}
