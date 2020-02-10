package com.ndvu.demo.service;

import com.ndvu.demo.model.Card;
import org.springframework.stereotype.Service;

@Service
public interface CardService {

    long createCard(Card c);

    Card getCard(long id);

    Iterable<Card> getAllCards();

    void updateCard(long id, Card c);

}
