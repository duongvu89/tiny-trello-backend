package com.ndvu.demo.resource;

import com.ndvu.demo.TinyTrelloBackEndApplication;
import com.ndvu.demo.model.Card;
import com.ndvu.demo.service.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardResource {
    private static final Logger logger = LogManager.getLogger(TinyTrelloBackEndApplication.class);
    private final CardService cardService;

    public CardResource(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createCard(@RequestBody Card card) {
        logger.info("Handling create card request");
        return ResponseEntity.ok(cardService.createCard(card));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCard(@PathVariable long id) {
        logger.info("Handling get card request");
        return ResponseEntity.ok(cardService.getCard(id));
    }

    @GetMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllCards() {
        logger.info("Handling get all cards request");
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity editCard(@PathVariable long id, @RequestBody Card card) {
        logger.info("Handling update card request");
        cardService.updateCard(id, card);
        return ResponseEntity.ok().build();
    }

}
