package com.epam.esm.exception;

public class TagAlreadyExistException extends RuntimeException{
    private String message;

    public TagAlreadyExistException() {
    }

    public TagAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
