package de.htwberlin.webtech.wi2425.persistence;

import de.htwberlin.webtech.wi2425.model.Deck;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository extends CrudRepository<Deck, Integer> {

}
