package com.ndvu.demo.exception;

public class ResourceNotFoundException extends TinyTrelloException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
