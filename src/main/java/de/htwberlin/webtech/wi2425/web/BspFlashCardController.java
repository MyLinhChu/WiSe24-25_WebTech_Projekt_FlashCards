package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BspFlashCardController {

    @GetMapping(path = "/flashcard")
    public ResponseEntity<LernSet> getLernSet(){
        final LernSet hauptstadt = new LernSet();
        hauptstadt.addFlashcard(new FlashCard("Deutschland" , "Berlin"));
        hauptstadt.addFlashcard(new FlashCard("Frankreich" , "Paris"));
        hauptstadt.addFlashcard(new FlashCard("Korea" , "Seoul"));
        return ResponseEntity.ok(hauptstadt);
    }
}
