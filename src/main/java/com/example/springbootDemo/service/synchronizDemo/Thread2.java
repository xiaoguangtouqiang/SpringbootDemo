package com.example.springbootDemo.service.synchronizDemo;

public class Thread2 {
    public void mythod1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public synchronized void mythod2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        final Thread2 myt2 = new Thread2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.mythod1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.mythod2();
            }
        });
        t1.start();
        t2.start();
    }
}
