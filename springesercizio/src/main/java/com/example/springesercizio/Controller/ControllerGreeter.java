package com.example.springesercizio.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esercizio")
public class ControllerGreeter {

    @GetMapping("/grreter")
    public ResponseEntity<String> getgreeter(){
        return ResponseEntity.ok("Good Afternoon");
    }


}
