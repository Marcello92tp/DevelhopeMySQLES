package com.example.esercizio4.spring.controller;

import com.example.esercizio4.spring.entity.Meal;
import com.example.esercizio4.spring.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/esercizi-develhope")
public class MealsController {

    @Autowired
    private final MealService service;

    public MealsController(MealService service) {
        this.service = service;
    }

    @GetMapping("/meals")
    public List<Meal> getAllMeals() {
        return service.getAllMeals();
    }

    @PostMapping("/add-meals")
    public Meal addMeal(@RequestBody Meal meal) {
        return service.addMeal(meal);
    }

    @GetMapping("/meal/{name}")
    public Optional<Meal> getMealByName(@PathVariable String name) {
        return service.getMealByName(name);
    }

    @GetMapping("/meal/description-match/{description}")
    public Optional<Meal> getMealByDescriptionPhrase(@PathVariable String description) {
        return service.getMealByDescriptionPhrase(description);
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
    public Optional<String> deleteMealByName(@PathVariable String name) {
        return service.deleteMealByName(name);
    }

    @DeleteMapping("/delete/meal/price/{price}")
    public Optional<String> deleteMealByPrice(@PathVariable Double price) {
        return service.deleteMealByPrice(price);
    }
}







