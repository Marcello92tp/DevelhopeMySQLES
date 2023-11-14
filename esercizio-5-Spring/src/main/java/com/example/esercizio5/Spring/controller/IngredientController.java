package com.example.esercizio5.Spring.controller;

import com.example.esercizio5.Spring.entity.Ingredient;
import com.example.esercizio5.Spring.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("ese5")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredients")
    public List<Ingredient> getAllMeals() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping("/add-ingredients")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @GetMapping("/ingredient/{name}")
    public ResponseEntity<Ingredient> getMealByName(@PathVariable String name) {
        Optional<Ingredient> opt = ingredientService.getIngredientByName(name);

        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/ingredient/{name}")
    public ResponseEntity<String> modifyIngredientName(@PathVariable String name, @RequestBody Ingredient updatedIngredient) {
        return ResponseEntity.ok(ingredientService.modifyIngredientName(name, updatedIngredient));
    }

    @DeleteMapping("/delete/all-ingredients")
    public String deleteAllIngredients() {
        return ingredientService.deleteAllIngredients();
    }

    @DeleteMapping("/delete/ingredient/name/{name}")
    public Optional<String> deleteIngredientByName(@PathVariable String name) {
        return ingredientService.deleteIngredientByName(name);
    }
}
