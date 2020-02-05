package com.ndvu.demo.resource;

import com.ndvu.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardResource {

    @Autowired
    private CardService cardService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getForm(@PathVariable long id) {
        return ResponseEntity.ok(cardService.getCard(id));
    }
}
