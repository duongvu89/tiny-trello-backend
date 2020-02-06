package com.ndvu.demo.resource;

import com.ndvu.demo.model.Card;
import com.ndvu.demo.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardResource {

    private final CardService cardService;

    public CardResource(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createCard(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.createCard(card));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCard(@PathVariable long id) {
        return ResponseEntity.ok(cardService.getCard(id));
    }

    @GetMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity editForm(@PathVariable long id, @RequestBody Card card) {
        cardService.updateCard(id, card);
        return ResponseEntity.ok().build();
    }

}
