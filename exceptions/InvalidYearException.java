package com.gijon.screenmatch.exceptions;

public class InvalidYearException extends RuntimeException {

    private String message;
    public InvalidYearException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
