package com.example.esercizio4.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esercizi-develhope")
public class HelloController {
   @GetMapping("/simply-hello-world")
   public String getHello(){
       return "Hello World";
   }

   @GetMapping("/greeting")
    public ResponseEntity<String> greetings() {
       String greeting = "Good Afternoon";
       return ResponseEntity.ok(greeting);
   }




}
