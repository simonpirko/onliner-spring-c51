package org.onliner.spring.c51.exception;

public class ProductTypeNotFound extends RuntimeException {

    public ProductTypeNotFound() {
        super();
    }

    public ProductTypeNotFound(String message) {
        super(message);
    }

    public ProductTypeNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeNotFound(Throwable cause) {
        super(cause);
    }

    protected ProductTypeNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
