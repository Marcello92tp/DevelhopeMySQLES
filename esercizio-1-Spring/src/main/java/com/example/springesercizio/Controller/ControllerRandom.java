package com.example.springesercizio.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/esercizio")
public class ControllerRandom {

    @GetMapping("/random")
    public ResponseEntity<String> getRandomResponse() {
        Random random = new Random();
        boolean isSuccessful = random.nextBoolean();
        if (isSuccessful) {
            return ResponseEntity.ok("Operazione riuscita (200 OK).");
        } else {
            return ResponseEntity.badRequest().body("Richiesta non valida (400 Bad Request).");
        }
    }
}
