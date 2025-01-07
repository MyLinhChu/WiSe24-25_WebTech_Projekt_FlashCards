package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.model.Deck;
import de.htwberlin.webtech.wi2425.model.FlashCard;
import de.htwberlin.webtech.wi2425.service.DeckService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/decks")
public class DeckController {

    private final DeckService deckService;

    // CRUD für Decks

    @GetMapping
    public ResponseEntity<Iterable<Deck>> getAllDecks() {
        return ResponseEntity.ok(deckService.getAllDecks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> getDeckById(@PathVariable int id) {
        Optional<Deck> deckOptional = deckService.getDeck(id);
        return deckOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Deck> createDeck(@Valid @RequestBody Deck deck) {
        Deck createdDeck = deckService.createDeck(deck);
        return new ResponseEntity<>(createdDeck, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeck(@PathVariable int id) {
        boolean deleted = deckService.deleteDeck(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{deckId}/description")
    public ResponseEntity<String> updateDeckDescription(
            @PathVariable int deckId,
            @RequestBody String description) {
        String updatedDescription = deckService.updateDeckDescription(deckId, description);
        return updatedDescription != null
                ? ResponseEntity.ok(updatedDescription)
                : ResponseEntity.notFound().build();
    }

    // FlashCard-Operationen innerhalb eines Decks

    @PostMapping("/{deckId}/flashcards")
    public ResponseEntity<FlashCard> addFlashCardToDeck(
            @PathVariable int deckId,
            @Valid @RequestBody FlashCard flashCard) {
        FlashCard createdCard = deckService.addFlashCardToDeck(deckId, flashCard);
        if (createdCard != null) {
            return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{deckId}/flashcards/{flashCardId}")
    public ResponseEntity<FlashCard> updateFlashCardInDeck(
            @PathVariable int deckId,
            @PathVariable int flashCardId,
            @Valid @RequestBody FlashCard flashCard) {
        FlashCard updatedCard = deckService.updateFlashCardInDeck(deckId, flashCardId, flashCard);
        return updatedCard != null ? ResponseEntity.ok(updatedCard) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{deckId}/flashcards/{flashCardId}")
    public ResponseEntity<Void> deleteFlashCardFromDeck(
            @PathVariable int deckId,
            @PathVariable int flashCardId) {
        boolean deleted = deckService.deleteFlashCardFromDeck(deckId, flashCardId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{deckId}/learn")
    public ResponseEntity<List<FlashCard>> getFlashCardsForLearning(@PathVariable int deckId) {
        Optional<Deck> deckOptional = deckService.getDeck(deckId);
        if (deckOptional.isPresent()) {
            Deck deck = deckOptional.get();
            List<FlashCard> shuffledCards = new ArrayList<>(deck.getCards());
            Collections.shuffle(shuffledCards); // Zufällige Reihenfolge
            return ResponseEntity.ok(shuffledCards);
        }
        return ResponseEntity.notFound().build();
    }

}