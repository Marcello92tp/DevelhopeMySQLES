package com.example.esercitazioneJpa.controller;

import com.example.esercitazioneJpa.entity.Utente;
import com.example.esercitazioneJpa.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    public UtenteService utenteService;
    public UtenteController(UtenteService utenteService){
        this.utenteService = utenteService;
    }
    //SELECT
    @GetMapping //Select
    public ResponseEntity<List<Utente>> selectAll(){
        List<Utente> list = utenteService.getAll();
        return ResponseEntity.ok(list);
    }
    @PostMapping("/add")
    public Utente addUtente(@RequestBody Utente utente){

        return utenteService.addUtente(utente);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delListUser(@PathVariable Long id){
        utenteService.deleteUtente(id);
        return ResponseEntity.ok("U cancellato");
    }
    @PutMapping("edit/{id}")
    public ResponseEntity<Utente> listaedit(@PathVariable Long id,@RequestBody Utente edutente){

    try{
        Optional<Utente> utmod = utenteService.editUtente(id, edutente);
        return ResponseEntity.ok(utmod.get());
    }catch (IllegalArgumentException e){
        return ResponseEntity.notFound().build();

    }

    }

}
