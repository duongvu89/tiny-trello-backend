package com.ndvu.demo.model;

import com.ndvu.demo.util.CardStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    private CardStatus status;

    public Card() {
    }

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
