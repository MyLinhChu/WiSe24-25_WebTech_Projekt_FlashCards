package de.htwberlin.webtech.wi2425.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String frage;
    private String antwort;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

}
