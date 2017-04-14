package ee.ttu.geocollection.domain;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

        private AppError error;

        private Throwable errorDetails;

        public AppException(AppError error) {

            this.error = error;

        }

        public AppException(AppError error, Throwable errorDetails) {

            this.error = error;
            this.errorDetails = errorDetails;
        }

    public String getErrorCode() {
        return error.getErrorCode();
    }

    public AppError getError() {
        return error;
    }

    public String getErrorDetails() {
        if (errorDetails == null) {
            return null;
        }
        return errorDetails.toString();
    }

    public HttpStatus getStatus() {

        return error.getStatus();
    }
}
