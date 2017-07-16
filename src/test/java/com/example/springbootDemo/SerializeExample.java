package com.example.springbootDemo;

import com.example.springbootDemo.dto.Animal;
import com.example.springbootDemo.dto.Elephant;
import com.example.springbootDemo.dto.Lion;
import com.example.springbootDemo.dto.Zoo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
public class SerializeExample {
    public static void main(String[] args) throws IOException {
        Zoo zoo = new Zoo("SH Wild Park", "ShangHai");
        Lion lion = new Lion("Samba");
        Elephant elephant = new Elephant("Manny");
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("zoo.json"), zoo);
    }
}
