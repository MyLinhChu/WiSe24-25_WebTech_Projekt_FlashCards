package de.htwberlin.webtech.wi2425;

import java.util.HashMap;

public class FlashCard {
    private String frage;
    private String antwort;


    public FlashCard(String frage, String antwort) {
        this.frage = frage;
        this.antwort = antwort;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }
}
