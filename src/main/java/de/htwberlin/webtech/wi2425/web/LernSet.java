package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class LernSet {

    private String name;
    private List<FlashCard> lernSet;

    public LernSet(String name) {
        this.name = name;
    }


    public void addFlashcard(FlashCard flashCard) {
        lernSet.add(flashCard);
    }

}
