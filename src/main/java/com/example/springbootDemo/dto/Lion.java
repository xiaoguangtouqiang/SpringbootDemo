package com.example.springbootDemo.dto;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
public class Lion extends Animal {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Lion(String name) {
        this.name = name;
    }

    public String getType() {
        return "carnivorous";
    }
}
