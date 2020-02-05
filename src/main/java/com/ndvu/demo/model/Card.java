package com.ndvu.demo.model;

import com.ndvu.demo.util.CardStatus;

public class Card {

    private long id;

    private String description;

    private CardStatus status;

    public Card(long id, String desc, CardStatus status) {
        this.id = id;
        this.description = desc;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }
}
