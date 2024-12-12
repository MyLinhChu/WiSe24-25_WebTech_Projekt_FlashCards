package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class LernSet {

    private String name;
    private List<FlashCard> sammlung;

    public LernSet(String name, List<FlashCard> sammlung) {
        this.name = name;
        this.sammlung = sammlung;
    }

}
