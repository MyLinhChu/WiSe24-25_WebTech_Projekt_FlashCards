package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;

import java.util.ArrayList;
import java.util.List;

public class LernSet {
    List<FlashCard> lernSet = new ArrayList<>();

    public LernSet() {
    }

    public void addFlashcard(FlashCard flashCard) {
        lernSet.add(flashCard);
    }

    public void deleteFlashcard(){

    }

    public List<FlashCard> getLernSet() {
        return lernSet;
    }

    public void setLernSet(List<FlashCard> lernSet) {
        this.lernSet = lernSet;
    }
}
