package com.example.esercizio4.spring.service;


import com.example.esercizio4.spring.DAO.MealDAO;
import com.example.esercizio4.spring.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private final MealDAO mealDAO;
    public MealService(MealDAO mealDAO) {
        this.mealDAO = mealDAO;
    }
    public List<Meal> getAllMeals(){
        return mealDAO.getMeals();
    }

    public Meal addMeal(Meal meal) {
        this.mealDAO.getMeals().add(meal);
        System.out.println("Meal added");
        return meal;
    }

    public Optional<Meal> getMealByName(String name) {
        for (Meal meal : mealDAO.getMeals()) {
            if (meal.getName().equals(name)) {
                return Optional.of(meal);
            }
        } return Optional.empty();
    }

    public Optional<Meal> getMealByDescriptionPhrase(String description) {
        for (Meal meal : mealDAO.getMeals()) {
            if (meal.getDescription().equals(description)) {
                return Optional.of(meal);
            }
        }   return Optional.empty();
    }


    public List<Meal> getMealByPriceRange(Double min, Double max) {
       List<Meal> mealsInThePriceRange = new ArrayList<>();
       for (Meal meal : mealDAO.getMeals()) {
            if (meal.getPrice() >= min && meal.getPrice() <= max) {
                mealsInThePriceRange.add(meal);

            }
        }   return mealsInThePriceRange;
    }



    public String modifyMealName(String name, Meal updatedMeal) {
        Meal mealToUpdate = mealDAO.getMeals().stream().filter(meal -> meal.getName().equals(name)).findAny().orElse(null);
        if (mealToUpdate != null) {
            mealToUpdate.setName(updatedMeal.getName());
            return "Name of the meal updated";
        }
        return "Name of the meal not updated";
    }


    public String modifyMealPriceByName(String name, Meal updatedMeal){
        for(Meal meal : mealDAO.getMeals()){
            if (meal.getName().equals(name)){
                meal.setPrice(updatedMeal.getPrice());
                return "Meals price has been updated";
            }
        } return "Meals price has not been updated";
    }

//Delete functions
    public String deleteAllMeals(){
     this.mealDAO.getMeals().clear();
      return "All meals have been deleted";
    }


    public Optional<String> deleteMealByName(String name) {
        Optional<Meal> mealOptional = mealDAO.getMeals().stream()
                .filter(meal -> meal.getName().equals(name))
                .findAny();

        if (mealOptional.isPresent()) {
            Meal mealForDelete = mealOptional.get();
            mealDAO.getMeals().remove(mealForDelete);
            return Optional.of("The meal with this name: " + name + " has been removed");
        } else {
            return Optional.of("Meal with the name " + name + " not found");
        }
    }


    public  Optional<String> deleteMealByPrice(Double price){
        List<Meal> mealsToDelete = new ArrayList<>();

        Optional<Meal> mealOptional = mealDAO.getMeals().stream().filter(meal -> meal.getPrice().equals(price)).findAny();
        if(mealOptional.isPresent()){
            Meal mealForDelete = mealOptional.get();
            mealDAO.getMeals().remove(mealForDelete);
            return Optional.of("The meal priced " + price + " has been removed");
        } else return Optional.of("The meal priced " + price + " does not exists");
    }




}









