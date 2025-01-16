package de.htwberlin.webtech.wi2425.service;


import de.htwberlin.webtech.wi2425.model.Deck;
import de.htwberlin.webtech.wi2425.model.FlashCard;
import de.htwberlin.webtech.wi2425.persistence.DeckRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)

    public class DeckServiceTest {
        @Autowired
        private DeckService service;

        @MockBean
        private DeckRepository repository;

        private Deck exampleDeck;
        private FlashCard exampleCard;

        @BeforeEach
        void setUpMockRepository() {
            exampleDeck = new Deck(1, "Test Deck", "Description", new ArrayList<>());
            exampleCard = new FlashCard(1, "Test Question", "Test Answer", exampleDeck);

            // Mock Deck Repository
            when(repository.findById(1)).thenReturn(Optional.of(exampleDeck));
            when(repository.findAll()).thenReturn(List.of(exampleDeck));
            when(repository.save(any(Deck.class))).thenAnswer(invocation -> invocation.getArgument(0));
            when(repository.existsById(1)).thenReturn(true);

        }

        @Test
        void testGetAllDecks() {
            Iterable<Deck> result = service.getAllDecks();
            assertEquals(1, ((List<Deck>) result).size(), "Should return one deck");
            assertEquals("Test Deck", ((List<Deck>) result).get(0).getName());
        }

        @Test
        void testGetDeckById() {
            Optional<Deck> result = service.getDeck(1);
            assertTrue(result.isPresent(), "Deck with ID 1 should be found");
            assertEquals("Test Deck", result.get().getName());
        }

        @Test
        void testGetDeckByIdNotFound() {
            Optional<Deck> result = service.getDeck(99);
            assertFalse(result.isPresent(), "Deck with ID 99 should not be found");
        }

        @Test
        void testCreateDeck() {
            Deck newDeck = new Deck(2, "New Deck", "New Description", List.of());
            Deck savedDeck = service.createDeck(newDeck);
            assertEquals("New Deck", savedDeck.getName(), "Deck name should match");
            verify(repository).save(newDeck);
        }

        @Test
        void testDeleteDeck() {
            boolean result = service.deleteDeck(1);
            assertTrue(result, "Deck with ID 1 should be deleted");
            verify(repository).deleteById(1);
        }

        @Test
        void testDeleteDeckNotFound() {
            boolean result = service.deleteDeck(99);
            assertFalse(result, "Deck with ID 99 should not be found for deletion");
            verify(repository, never()).deleteById(99);
        }

        @Test
        void testUpdateDeckDescription() {
            String updatedDescription = service.updateDeckDescription(1, "Updated Description");
            assertEquals("Updated Description", updatedDescription, "Description should be updated");
        }

        @Test
        void testAddFlashCardToDeck() {
            FlashCard card = new FlashCard(2, "Question", "Answer", null);
            FlashCard result = service.addFlashCardToDeck(1, card);
            assertNotNull(result, "FlashCard should be added to deck");
            assertEquals("Question", result.getFrage());
            assertEquals(exampleDeck, result.getDeck());
        }

        @Test
        void testDeleteFlashCardFromDeck() {
            exampleDeck.getCards().add(exampleCard);
            boolean result = service.deleteFlashCardFromDeck(1, 1);
            assertTrue(result, "FlashCard should be deleted from deck");
            assertTrue(exampleDeck.getCards().isEmpty(), "Deck should have no cards left");
        }

        @Test
        void testUpdateFlashCardInDeck() {
            exampleDeck.getCards().add(exampleCard);
            FlashCard updatedCard = new FlashCard(1, "Updated Question", "Updated Answer", null);
            FlashCard result = service.updateFlashCardInDeck(1, 1, updatedCard);
            assertNotNull(result, "FlashCard should be updated");
            assertEquals("Updated Question", result.getFrage());
            assertEquals("Updated Answer", result.getAntwort());
        }
    }


