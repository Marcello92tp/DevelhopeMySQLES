package com.example.esercizio5.Spring.controller;

import com.example.esercizio5.Spring.entity.Meal;
import com.example.esercizio5.Spring.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/ese5")
public class MealController {
    @Autowired
    private MealService service;

    @GetMapping("/meals")
    public List<Meal> getAllMeals() {
        return service.getAllMeals();
    }

    @PostMapping("/add-meals")
    public Meal addMeal(@RequestBody Meal meal) {
        return service.addMeal(meal);
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<Meal> getMealByName(@PathVariable String name) {
        Optional<Meal> opt = service.getMealByName(name);
        if(opt.isPresent()){
            return ResponseEntity.ok(opt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/meal/description-match/{description}")
    public ResponseEntity<Meal> getMealByDescriptionPhrase(@PathVariable String description) {
        Optional<Meal> opt = service.getMealByDescriptionPhrase(description);

        if(opt.isPresent()){
            return ResponseEntity.ok(opt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/meal/price")
    public List<Meal> getMealByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return service.getMealByPriceRange(min, max);
    }


    @PutMapping("/meal/{name}")
    public ResponseEntity<String> modifyMealName(@PathVariable String name, @RequestBody Meal updatedMeal) {
        return ResponseEntity.ok(service.modifyMealName(name, updatedMeal));
    }


    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> modifyMealPriceByName(@PathVariable String name, @RequestBody Meal updatedMeal) {
        return ResponseEntity.ok(service.modifyMealPriceByName(name, updatedMeal));
    }


    @DeleteMapping("/delete/all-meals")
    public String deleteAllMeals() {
        return service.deleteAllMeals();
    }


    @DeleteMapping("/delete/meal/name/{name}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String name) {
        Optional<String> opt = service.deleteMealByName(name);
        if(opt.isPresent()){
            return ResponseEntity.ok("Meal: " + name + " has been eliminated");
        } else{
            return  ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/meal/price/{price}")
    public Optional<String> deleteMealByPrice(@PathVariable Double price) {
        return service.deleteMealByPrice(price);
    }



}
