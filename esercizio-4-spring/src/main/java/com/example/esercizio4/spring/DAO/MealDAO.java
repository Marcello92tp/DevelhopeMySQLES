package com.example.esercizio4.spring.DAO;

import com.example.esercizio4.spring.entity.Meal;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MealDAO {
    List<Meal> listOfMeals = new ArrayList<>();
    public List<Meal> getMeals(){
        return listOfMeals;
    }




}




