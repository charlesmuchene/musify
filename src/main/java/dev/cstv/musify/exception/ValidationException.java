package dev.cstv.musify.exception;

public class ValidationException extends RuntimeException {

    private String exception;

    public ValidationException() {

    }

    public ValidationException(String exception) {

        super(exception);
        this.exception = exception;

    }

    public String getException() {

        return exception;
    }
}
