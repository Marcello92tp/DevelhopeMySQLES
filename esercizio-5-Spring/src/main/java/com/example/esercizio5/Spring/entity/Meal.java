package com.example.esercizio5.Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Meal {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
    private String name;
    private String description;
    private Double price;

//    public Meal(Long id, String name, String description, Double price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }

    public Meal(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Meal(){

    }
    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
