package com.example.springbootDemo.service.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by wangdi on 2017/8/10.
 */
public class LambShapeFactory {

    final static Map<String, Supplier<Shape>> map = new HashMap<>();

    static {
        map.put("CIRCLE", Circle::new);
        map.put("RECTANGLE", Rectangle::new);
    }

    public static Shape getShape(String shapeType){
        Supplier<Shape> supplier = map.get(shapeType.toUpperCase());
        if(supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("No such shape " + shapeType.toUpperCase());
    }

    public static void main(String[] args) {
        LambShapeFactory.getShape("CIRCLE").draw();
        LambShapeFactory.getShape("RECTANGLE").draw();
    }
}
