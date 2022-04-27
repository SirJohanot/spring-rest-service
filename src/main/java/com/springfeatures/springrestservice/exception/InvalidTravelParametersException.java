package com.springfeatures.springrestservice.exception;

public class InvalidTravelParametersException extends Exception {

    public InvalidTravelParametersException() {
    }

    public InvalidTravelParametersException(String message) {
        super(message);
    }

    public InvalidTravelParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTravelParametersException(Throwable cause) {
        super(cause);
    }

    public InvalidTravelParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
