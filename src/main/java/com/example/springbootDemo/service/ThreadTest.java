package com.example.springbootDemo.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
//        RunnableImpl runnable = new RunnableImpl();
//        Thread thread = new Thread(runnable);
//        List<String> list = new ArrayList<>();
//        thread.start();
//        for (int i = 0; i < 100; i++) {
//            System.out.println("main:" + i);
//        }
        String[] array = new String[]{"aa", "bb", "cc"};
        List<String> strings = Arrays.asList(array);
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.printf(iterator.next());
        }
        String[] objects = (String[]) strings.toArray();
        System.out.printf("objects:"+objects[0]);
        System.out.printf("strings:"+strings.toString());
    }
}
