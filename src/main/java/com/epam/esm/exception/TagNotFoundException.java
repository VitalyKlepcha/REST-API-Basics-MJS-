package com.epam.esm.exception;

public class TagNotFoundException extends RuntimeException{
    private String message;

    public TagNotFoundException() {
    }

    public TagNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
