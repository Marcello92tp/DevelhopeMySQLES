package com.example.esercizio5.Spring.Dao;

import com.example.esercizio5.Spring.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<Ingredient,Long> {
}
