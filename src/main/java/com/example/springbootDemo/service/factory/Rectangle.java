package com.example.springbootDemo.service.factory;

/**
 * Created by wangdi on 2017/8/10.
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
