package com.example.springbootDemo.dto;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
public class Elephant extends Animal {
    private String name;

    public String getType() {
        return "herbivorous";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Elephant(String name) {
        this.name = name;
    }


}
