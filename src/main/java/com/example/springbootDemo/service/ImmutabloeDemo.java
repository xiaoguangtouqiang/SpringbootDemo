package com.example.springbootDemo.service;

public class ImmutabloeDemo {
    private final int[] myArray;

    public ImmutabloeDemo(int[] array) {
        this.myArray = array.clone();
    }

    public static void main(String[] args) {
        String one = "someString";
        String two = "someString";
        System.out.println(one==two);
        boolean equsaas = one==two;
        String a1 = new String("haha");
        String a2 = new String("haha");
        System.out.println(a1 == a2);

        System.out.printf("one:"+one);

        String a  = "ABC";
        String b = "AB";
        String c = b + "C";
        System.out.println( a == c );//false
    }
}
