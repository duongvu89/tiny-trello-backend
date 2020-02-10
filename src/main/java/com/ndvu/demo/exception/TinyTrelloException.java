package com.ndvu.demo.exception;

public class TinyTrelloException extends RuntimeException {

    public TinyTrelloException() {
    }

    public TinyTrelloException(String msg) {
        super(msg);
    }
}
