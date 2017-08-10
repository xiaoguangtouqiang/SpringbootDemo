package com.example.springbootDemo.dto;

import java.util.LinkedList;

/** 基本语法
 * Created by wangdi on 2017/8/10.
 */
public class BasicProgram {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("sss");
        linkedList.add("seeess");
        linkedList.poll();
        System.out.printf(linkedList.toString());
    }
}
