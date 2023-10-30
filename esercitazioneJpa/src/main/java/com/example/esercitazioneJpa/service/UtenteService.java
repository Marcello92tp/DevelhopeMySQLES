package com.example.esercitazioneJpa.service;

import com.example.esercitazioneJpa.entity.Utente;
import com.example.esercitazioneJpa.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    public UtenteRepository utenteRepository;

   public Utente addUtente(Utente utente){
       return utenteRepository.save(utente);
  }
public void deleteUtente(Long id){
       utenteRepository.deleteById(id);
}
public List<Utente> editUtente(){
       return utenteRepository.findAll();
}
public Optional<Utente> editUtente(Long id, Utente edUtente){
       Optional<Utente> currUtenteOpt = utenteRepository.findById(id);
       if(currUtenteOpt.isPresent()){
           currUtenteOpt.get().setNome(edUtente.getNome());
           currUtenteOpt.get().setCognome(edUtente.getCognome());
           currUtenteOpt.get().setEmail(edUtente.getEmail());
           utenteRepository.save(edUtente);
       }return Optional.of(edUtente);
}
public List<Utente> getAll(){
     return   utenteRepository.findAll();
}














}
