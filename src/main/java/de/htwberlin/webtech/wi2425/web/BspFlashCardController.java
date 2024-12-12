package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BspFlashCardController {





    @GetMapping(path = "/flashcard")
    public ResponseEntity<LernSet> getLernSet(){
        List<FlashCard> hauptstadtSammlung = new ArrayList<>();
        hauptstadtSammlung.add(new FlashCard("Deutschland" , "Berlin"));
        hauptstadtSammlung.add(new FlashCard("Frankreich" , "Paris"));
        hauptstadtSammlung.add(new FlashCard("Korea" , "Seoul"));
        final LernSet hauptstadt = new LernSet("Hauptstadt", hauptstadtSammlung);
        return ResponseEntity.ok(hauptstadt);
    }
}
