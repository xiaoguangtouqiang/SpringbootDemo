package com.example.springbootDemo.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
public class Zoo {
    public String name;
    public String city;
    public List<Animal> animals;


    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
