package com.example.esercizio5.Spring.Dao;

import com.example.esercizio5.Spring.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealDAO extends JpaRepository<Meal,Long> {
}
