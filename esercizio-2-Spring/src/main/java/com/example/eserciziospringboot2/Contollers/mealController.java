package com.example.eserciziospringboot2.Contollers;

import com.example.eserciziospringboot2.Entity.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//RESTc
//RESTm
@RestController
@RequestMapping("/meals")
public class mealController {
    //cominciare sempre dalla lista
    List<Meal> listMeals = new ArrayList<>();

    //Visualizza lista
    @GetMapping("/seeList")
    public List<Meal> methodGetList() {
        return listMeals;
    }
    //metodo aggiungi
    @PostMapping("/add")
    public String methodAddToList(@RequestBody Meal meal1) {
        listMeals.add(meal1);
            return "Meal Name: " + meal1.getName()
                    + "\nMeal Id: " + meal1.getId()
                    + "\nMeal Description: " + meal1.getDescription()
                    + "\nMeal Price: "+ meal1.getPrice();
        }

    //ricerca per nome
    @GetMapping("/list/{name}")
    public List<Meal> methodGetByName(@PathVariable String name) {
        List<Meal> listByName = new ArrayList<>();
        for (Meal l2 : listMeals) {
            if (l2.getName().contains(name)) {
                listByName.add(l2);
            }
        }

        return listByName;
    }
    //ricerca per Descrizione
    @GetMapping("/list/{desc}")
    public List<Meal> methodGetByDescription(@PathVariable String desc) {
        List<Meal> listByDesc = new ArrayList<>();
        for (Meal l2 : listMeals) {
            if (l2.getDescription().contains(desc)) {
                listByDesc.add(l2);
            }
        }

        return listByDesc;
    }

    //ricerca per prezzo minimo e massimo.
    @GetMapping("/list/{min}/{max}")
    public List<Meal> methodGetMinAndMmaxPrice(@PathVariable Integer minP,@PathVariable Integer maxP) {
        List<Meal> listMiMa = new ArrayList<>();
        //for each su listmeals o la lista oroginale che abbiamo creato in precednza.
        for (Meal l2 : listMeals) {
            //Ciclare con su listmeals
            if (l2.getPrice() >= minP && l2.getPrice() <= maxP) {
                listMiMa.add(l2);
            }
        }
// ritorna la lista che hai creato nel metodo a cui con il ciclo if aggiungiamo i valori
        return listMiMa;
    }
}
