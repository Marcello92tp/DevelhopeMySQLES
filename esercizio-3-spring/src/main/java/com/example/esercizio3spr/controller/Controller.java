package com.example.esercizio3spr.controller;

import com.example.esercizio3spr.entity.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lista")
public class Controller {

    List<Meal> mealList = new ArrayList<>();

    @GetMapping("/menu")
    public List<Meal> vedilista() {
        return mealList;
    }

    @GetMapping("/prezzo/{min}/{max}")
    public List<Meal> deletePastiByPrezzo(
            @PathVariable("min") double minPrezzo,
            @PathVariable("max") double maxPrezzo) {

        List<Meal> mealMinMax = new ArrayList<>();

        for (Meal meal : mealList) {
            if (meal.getPrezzo() >= minPrezzo && meal.getPrezzo() <= maxPrezzo) {
                mealMinMax.add(meal);
            }
        }
        return mealMinMax;
    }

    @PostMapping("/menufisso")
    public String aggiungiPiattiFissi() {
        Meal meal1 = new Meal(1, "panino", "pane al salame e rucola fresca con un'aroma di salsa barbecue", 12);
        Meal meal2 = new Meal(2, "pizza", "sugo e farina con il gustoso prosciutto e rucola fresca con un'aroma fresco di basilico", 22);
        Meal meal3 = new Meal(3, "pizza classica", "sugo e farina e un'aroma fresco di basilico", 8);
        Meal meal4 = new Meal(4, "pizza lusso", "sugo e farina con un travolgente sapore di mare e montagna super fresco e un pizzico di aromi e mix di spezie", 87);

        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);
        mealList.add(meal4);

        return "Piatti fissi aggiunti";
    }

    @PostMapping("/aggiungi")
    public String aggiuniPiatto(@RequestBody Meal meal) {
        mealList.add(meal);
        return "Piatto aggiunto";
    }

    @PutMapping("/editpasto/{name}")
    public String editPiatto(@PathVariable String name, @RequestBody Meal editmeal) {
        for (Meal meal : mealList) {
            if (meal.getNome().equals(name)) {
                meal.setNome(editmeal.getNome());
                return "Piatto Modificato";
            }
        }

        return "Il piatto non è stato trovato";
    }

    @DeleteMapping("/elimina/{pasto}")
    public String deletePiatto(@PathVariable String pasto) {
        for (Meal meal : mealList) {
            if (meal.getNome().equalsIgnoreCase(pasto)) {
                mealList.remove(meal);
                return "Pasto rimosso: " + pasto;
            }
        }

        return "Pasto non trovato: " + pasto;
    }

    @DeleteMapping("/elimina/{min}/{max}")
    public String getPastiByPrezzo(
            @PathVariable("min") double minimoPrezzo,
            @PathVariable("max") double massimoPrezzo) {

        List<Meal> pastiDaEliminare = new ArrayList<>();

        for (Meal meal : mealList) {
            if (meal.getPrezzo() >= minimoPrezzo && meal.getPrezzo() <= massimoPrezzo) {
                pastiDaEliminare.add(meal);
            }
        }

        mealList.removeAll(pastiDaEliminare);

        return "nessun pasto trovato tra questi valori";
    }

}