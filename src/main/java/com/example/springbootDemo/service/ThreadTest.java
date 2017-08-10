package com.example.springbootDemo.service;

/**
 * 线程操作
 * Created by wangdi on 2017/8/10.
 */
public class ThreadTest {

    static class RunnableImpl implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread-----:" + i);
            }
        }
    }

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);
//        thread.run();
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:" + i);
        }


    }
}
