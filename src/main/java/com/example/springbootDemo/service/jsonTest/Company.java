package com.example.springbootDemo.service.jsonTest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Company {
    private String name;
    @JsonProperty("HQ")
    private String headquarters;
    private Department[] departments;
    @JsonIgnore         //在序列化与反序列化时，忽略birthDate属性
    private Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @JsonCreator
    public Company(@JsonProperty("name") String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); //禁止未知属性打断反序列化

        File src = new File("company_back.json");
        Company company = mapper.readValue(src, Company.class);
        System.out.print("company_name:"+company.getName()+"\t");
        System.out.print("headquarters:"+company.getHeadquarters()+"\t");
        System.out.println("birthDate:"+company.getBirthDate()); //birthDate被标记为@JsonIgnore，所以此处得到的值应该为null

        Department[] departments = company.getDepartments();

        for (Department department : departments) {
            System.out.print("department_name:" + department.getName()+"\t");
            System.out.print("employee_number:" + department.getPm()+"\t");
            //Department中未定义的字段product,employee_number
            System.out.print("product:"+department.get("product")+"\t");
            System.out.println("projectManager:"+department.get("employee_number"));
        }
    }
}
