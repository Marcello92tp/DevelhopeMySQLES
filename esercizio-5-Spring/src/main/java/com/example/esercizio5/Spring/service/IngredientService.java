package com.example.esercizio5.Spring.service;

import com.example.esercizio5.Spring.Dao.IngredientDAO;
import com.example.esercizio5.Spring.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IngredientService {

    @Autowired
    private IngredientDAO ingredientDAO;

    public List<Ingredient> getAllIngredients(){
        return ingredientDAO.findAll();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        this.ingredientDAO.save(ingredient);
        System.out.println("Ingredient added");
        return ingredient;
    }

    public Optional<Ingredient> getIngredientByName(String name) {
        for (Ingredient ingredient : ingredientDAO.findAll()) {
            if (ingredient.getName().equals(name)) {
                return Optional.of(ingredient);
            }
        } return Optional.empty();
    }


    public String modifyIngredientName(String name, Ingredient updatedIngredient) {
        Ingredient ingredientToUpdate = ingredientDAO.findAll().stream().filter(ingredient -> ingredient.getName().equals(name)).findAny().orElse(null);
        if (updatedIngredient != null) {
            assert ingredientToUpdate != null;
            ingredientToUpdate.setName(updatedIngredient.getName());
            ingredientDAO.save(ingredientToUpdate);
            return "Name of the ingredient updated";
        }
        return "Name of the ingredient not updated";
    }


    //Delete functions
    public String deleteAllIngredients(){
        this.ingredientDAO.deleteAll();
        return "All ingredients have been deleted";
    }


    public Optional<String> deleteIngredientByName(String name) {
        Optional<Ingredient> ingredientOptional = ingredientDAO.findAll().stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findAny();

        if (ingredientOptional.isPresent()) {
            Ingredient ingredientForDelete = ingredientOptional.get();
            ingredientDAO.delete(ingredientForDelete);
            return Optional.of("The ingredient with this name: " + name + " has been removed");
        } else {
            return Optional.of("Ingredient with the name " + name + " not found");
        }
    }
}
