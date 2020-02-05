package com.ndvu.demo.service;

import com.ndvu.demo.model.Card;
import com.ndvu.demo.util.CardStatus;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {


    @Override
    public long createCard(Card c) {
        return 100;
    }

    @Override
    public Card getCard(long id) {
        return new Card(1, "This is the first card!", CardStatus.DOING);
    }

    @Override
    public void updateCard(Card c) {
    }
}
