package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BspFlashCardController {

    @GetMapping(path = "/api/decks")
    public ResponseEntity<List<Deck>> getDecks() {
        // FlashCards erstellen
        List<FlashCard> cards = Arrays.asList(
                new FlashCard("Deutschland", "Berlin"),
                new FlashCard("Frankreich", "Paris"),
                new FlashCard("Korea", "Seoul")
        );

        // Ein Deck mit den FlashCards erstellen
        Deck deck = new Deck();
        deck.setId(1);
        deck.setName("Hauptstädte");
        deck.setDescription("Hauptstädte der Welt");
        deck.setCards(cards);
        deck.setTags(Arrays.asList("geography", "general knowledge"));
        deck.setCreatedAt("2024-01-28T12:00:00Z");
        deck.setUpdatedAt("2024-01-28T12:00:00Z");

        // Ein Array mit diesem einen Deck zurückgeben
        return ResponseEntity.ok(Arrays.asList(deck));
    }
}
