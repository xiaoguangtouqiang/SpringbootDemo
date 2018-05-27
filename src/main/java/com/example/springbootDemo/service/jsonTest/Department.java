package com.example.springbootDemo.service.jsonTest;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Department {
    private String name;
    private String pm;
    private Map<String, Object> othersProperties = new HashMap<>();

    @JsonCreator
    public Department(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("projectManager")  //将company.json中projectManager字段关联到getPm方法
    public String getPm() {
        return pm;
    }

    @JsonAnyGetter
    public Map<String, Object> any() {
        return othersProperties;
    }

    @JsonAnySetter
    public void set(String key, Object obj) {
        othersProperties.put(key, obj);
    }

    public Object get(String key) {
        return othersProperties.get(key);
    }

}
