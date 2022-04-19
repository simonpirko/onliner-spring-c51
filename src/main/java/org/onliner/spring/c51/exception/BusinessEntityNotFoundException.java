package org.onliner.spring.c51.exception;

public class BusinessEntityNotFoundException extends RuntimeException {

    public BusinessEntityNotFoundException() {
    }

    public BusinessEntityNotFoundException(String message) {
        super(message);
    }

    public BusinessEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessEntityNotFoundException(Throwable cause) {
        super(cause);
    }

    public BusinessEntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
