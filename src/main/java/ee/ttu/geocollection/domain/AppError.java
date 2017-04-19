package ee.ttu.geocollection.domain;

import org.springframework.http.HttpStatus;

public enum AppError {
    BAD_REQUEST("error.request.failed", HttpStatus.BAD_REQUEST),
    ERROR_API_UNAVAILABLE("error.api.service.gone", HttpStatus.SERVICE_UNAVAILABLE);

    private String errorCode;

    private HttpStatus status;

    AppError(String errorCode, HttpStatus status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
