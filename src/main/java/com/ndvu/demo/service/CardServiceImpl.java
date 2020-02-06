package com.ndvu.demo.service;

import com.ndvu.demo.model.Card;
import com.ndvu.demo.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public long createCard(Card c) {
        cardRepository.save(c);
        return c.getId();
    }

    @Override
    public Optional<Card> getCard(long id) {
        return cardRepository.findById(id);
    }

    @Override
    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void updateCard(long id, Card c) {
        // According to https://tools.ietf.org/html/rfc7231#section-4.3.4
        Card card = cardRepository.findById(id).get();
        card.setId(c.getId());
        card.setDescription(c.getDescription());
        card.setStatus(c.getStatus());
        cardRepository.save(card);
    }
}
