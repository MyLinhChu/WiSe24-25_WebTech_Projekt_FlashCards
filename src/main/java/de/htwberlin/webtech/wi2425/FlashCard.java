package de.htwberlin.webtech.wi2425;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlashCard {
    private String frage;
    private String antwort;


    public FlashCard(String frage, String antwort) {
        this.frage = frage;
        this.antwort = antwort;
    }

}
