package de.htwberlin.webtech.wi2425.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlashCard {
    private String frage;
    private String antwort;

}
