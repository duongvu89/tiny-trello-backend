package com.ndvu.demo.service;

import com.ndvu.demo.model.Card;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CardService {

    long createCard(Card c);

    Optional<Card> getCard(long id);

    Iterable<Card> getAllCards();

    void updateCard(long id, Card c);

}
