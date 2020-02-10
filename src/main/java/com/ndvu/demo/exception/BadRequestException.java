package com.ndvu.demo.exception;

public class BadRequestException extends TinyTrelloException {
    public BadRequestException(String msg) {
        super(msg);
    }
}
