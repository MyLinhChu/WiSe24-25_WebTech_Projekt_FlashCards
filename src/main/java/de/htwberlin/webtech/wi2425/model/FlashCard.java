package de.htwberlin.webtech.wi2425.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference // Prevent recursive serialization
    private Deck deck;

}
