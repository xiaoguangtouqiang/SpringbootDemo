package com.example.springbootDemo;

import com.example.springbootDemo.dto.NutritionFacts;

import java.io.IOException;

/**
 * build 构造类
 * Created by Administrator on 2017/7/16 0016.
 */
public class BuildModeTest {
    public static void main(String[] args) throws IOException {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27).build();
    }
}
