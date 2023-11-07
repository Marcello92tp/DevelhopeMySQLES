package com.example.esercizio4.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esercizi-develhope")
public class InfoController {
    @GetMapping("/info")
    public ResponseEntity<String> getInfoResponse(){
        return ResponseEntity.ok("This is the info endpoint");
    }


}





