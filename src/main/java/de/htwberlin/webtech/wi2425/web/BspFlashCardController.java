package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BspFlashCardController {

    @GetMapping(path = "/flashcard")
    public ResponseEntity<LernSet> getLernSet(){
        final LernSet hauptstadt = new LernSet();
        hauptstadt.add(new FlashCard("Deutschland" , "Berlin"));
        hauptstadt.add(new FlashCard("Frankreich" , "Paris"));
        hauptstadt.add(new FlashCard("Korea" , "Seoul"));
        return ResponseEntity.ok(hauptstadt);
    }
}