package com.example.springbootDemo.service.threadTest;

public class MyThreadTest extends Thread {

    public void run(){
        System.out.printf("thread run!!");
    }

    public static void main(String[] args) {
        MyThreadTest myThreadTest = new MyThreadTest();
        myThreadTest.start();
    }
}
