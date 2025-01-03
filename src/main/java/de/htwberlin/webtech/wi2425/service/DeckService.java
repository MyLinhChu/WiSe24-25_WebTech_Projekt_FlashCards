package de.htwberlin.webtech.wi2425.service;

import de.htwberlin.webtech.wi2425.model.Deck;
import de.htwberlin.webtech.wi2425.model.FlashCard;
import de.htwberlin.webtech.wi2425.persistence.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;


    public Iterable<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    public Optional<Deck> getDeck(int id) {
        return deckRepository.findById(id);
    }

    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    public boolean deleteDeck(int id) {
        if (deckRepository.existsById(id)) {
            deckRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public String updateDeckDescription(int deckId, String description) {
        Optional<Deck> deckOptional = deckRepository.findById(deckId);
        if (deckOptional.isPresent()) {
            Deck deck = deckOptional.get();
            deck.setDescription(description); // Beschreibung setzen
            deckRepository.save(deck); // Änderungen speichern
            return deck.getDescription();
        }
        return null; // Falls Deck nicht gefunden wird
    }

    public FlashCard addFlashCardToDeck(int deckId, FlashCard flashCard) {
        Optional<Deck> deckOptional = deckRepository.findById(deckId);
        if (deckOptional.isPresent()) {
            Deck deck = deckOptional.get();
            flashCard.setDeck(deck);
            deck.getCards().add(flashCard); // FlashCard zur Liste hinzufügen
            deckRepository.save(deck); // Deck inklusive neuer FlashCard speichern
            return flashCard;
        }
        return null;
    }

    public boolean deleteFlashCardFromDeck(int deckId, int flashCardId) {
        Optional<Deck> deckOptional = deckRepository.findById(deckId);
        if (deckOptional.isPresent()) {
            Deck deck = deckOptional.get();
            Optional<FlashCard> cardOptional = deck.getCards().stream()
                    .filter(card -> card.getId() == flashCardId)
                    .findFirst();
            if (cardOptional.isPresent()) {
                deck.getCards().remove(cardOptional.get()); // FlashCard aus Liste entfernen
                deckRepository.save(deck); // Änderungen speichern
                return true;
            }
        }
        return false;
    }

    public FlashCard updateFlashCardInDeck(int deckId, int flashCardId, FlashCard updatedFlashCard) {
        Optional<Deck> deckOptional = deckRepository.findById(deckId);
        if (deckOptional.isPresent()) {
            Deck deck = deckOptional.get();
            Optional<FlashCard> cardOptional = deck.getCards().stream()
                    .filter(card -> card.getId() == flashCardId)
                    .findFirst();
            if (cardOptional.isPresent()) {
                FlashCard existingFlashCard = cardOptional.get();
                existingFlashCard.setFrage(updatedFlashCard.getFrage());
                existingFlashCard.setAntwort(updatedFlashCard.getAntwort());
                deckRepository.save(deck); // Änderungen speichern
                return existingFlashCard;
            }
        }
        return null;
    }
}
