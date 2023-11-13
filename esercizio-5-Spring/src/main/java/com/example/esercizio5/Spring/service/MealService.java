package com.example.esercizio5.Spring.service;

import com.example.esercizio5.Spring.Dao.MealDAO;
import com.example.esercizio5.Spring.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealDAO mealDAO;

    public MealService(MealDAO mealDAO) {
        this.mealDAO = mealDAO;
    }

    public List<Meal> getAllMeals() {
        return mealDAO.findAll();
    }

    public Meal addMeal(Meal meal) {
        this.mealDAO.save(meal);
        System.out.println("Meal added");
        return meal;
    }

    public Optional<Meal> getMealByName(String name) {
        for (Meal meal : mealDAO.findAll()) {
            if (meal.getName().equals(name)) {
                return Optional.of(meal);
            }
        }
        return Optional.empty();
    }

    public Optional<Meal> getMealByDescriptionPhrase(String description) {
        for (Meal meal : mealDAO.findAll()) {
            if (meal.getDescription().equals(description)) {
                return Optional.of(meal);
            }
        }
        return Optional.empty();
    }


    public List<Meal> getMealByPriceRange(Double min, Double max) {
        List<Meal> mealsInThePriceRange = new ArrayList<>();
        for (Meal meal : mealDAO.findAll()) {
            if (meal.getPrice() >= min && meal.getPrice() <= max) {
                mealsInThePriceRange.add(meal);

            }
        }
        return mealsInThePriceRange;
    }


    public String modifyMealName(String name, Meal updatedMeal) {
        Meal mealToUpdate = mealDAO.findAll().stream().filter(meal -> meal.getName().equals(name)).findAny().orElse(null);
        if (mealToUpdate != null) {
            mealToUpdate.setName(updatedMeal.getName());
            mealDAO.save(mealToUpdate);
            return "Name of the meal updated";
        }
        return "Name of the meal not updated";
    }


    public String modifyMealPriceByName(String name, Meal updatedMeal) {
        for (Meal meal : mealDAO.findAll()) {
            if (meal.getName().equals(name)) {
                meal.setPrice(updatedMeal.getPrice());
                mealDAO.save(meal);
                return "Meals price has been updated";
            }
        }
        return "Meals price has not been updated";
    }

    //Delete functions
    public String deleteAllMeals() {
        this.mealDAO.deleteAll();
        return "All meals have been deleted";
    }


    public Optional<String> deleteMealByName(String name) {
        Optional<Meal> mealOptional = mealDAO.findAll().stream()
                .filter(meal -> meal.getName().equals(name))
                .findAny();

        if (mealOptional.isPresent()) {
            Meal mealForDelete = mealOptional.get();
            mealDAO.delete(mealForDelete);
            return Optional.of("Meal with this name: " + name + " has been removed");
        } else {
            return Optional.of("Meal with name " + name + " not found");
        }
    }


    public Optional<String> deleteMealByPrice(Double price) {
        List<Meal> mealsToDelete = new ArrayList<>();

        Optional<Meal> mealOptional = mealDAO.findAll().stream().filter(meal -> meal.getPrice().equals(price)).findAny();
        if (mealOptional.isPresent()) {
            Meal mealForDelete = mealOptional.get();
            mealDAO.delete(mealForDelete);
            return Optional.of("The meal priced " + price + " has been removed");
        } else return Optional.of("The meal priced " + price + " does not exists");
    }
}