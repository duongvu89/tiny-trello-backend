package com.ndvu.demo.service;

import com.ndvu.demo.exception.BadRequestException;
import com.ndvu.demo.exception.ResourceNotFoundException;
import com.ndvu.demo.model.Card;
import com.ndvu.demo.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public long createCard(Card c) {
        if (c.getDescription() == null || c.getDescription().isEmpty()
                || c.getStatus() == null || c.getStatus().toString().isEmpty()) {
            throw new BadRequestException("Bad request body!");
        }
        cardRepository.save(c);
        return c.getId();
    }

    @Override
    public Card getCard(long id) {
        return cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card is not exits!"));
    }

    @Override
    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void updateCard(long id, Card c) {
        // According to https://tools.ietf.org/html/rfc7231#section-4.3.4
        if (c.getDescription() == null || c.getDescription().isEmpty()
                || c.getStatus() == null || c.getStatus().toString().isEmpty()) {
            throw new BadRequestException("Bad request body!");
        }
        Card card = getCard(id);
        card.setId(c.getId());
        card.setDescription(c.getDescription());
        card.setStatus(c.getStatus());
        cardRepository.save(card);
    }
}
