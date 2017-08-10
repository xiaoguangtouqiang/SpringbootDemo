package com.example.springbootDemo.service.factory;

/**
 * Created by wangdi on 2017/8/10.
 */
public class Circle implements Shape {

    private String r;

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method."+r);
    }

}
