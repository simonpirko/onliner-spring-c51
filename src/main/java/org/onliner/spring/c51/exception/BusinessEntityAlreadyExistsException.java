package org.onliner.spring.c51.exception;

public class BusinessEntityAlreadyExistsException extends RuntimeException {

    public BusinessEntityAlreadyExistsException() {
    }

    public BusinessEntityAlreadyExistsException(String message) {
        super(message);
    }

    public BusinessEntityAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessEntityAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public BusinessEntityAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
