package com.example.springbootDemo.service.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SomeCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.printf("SomeCallable!!!");
        Thread.sleep(500);
        return "hello";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable oneCallable = new SomeCallable();
        FutureTask<String> oneTask = new FutureTask<>(oneCallable);
        Thread oneThread = new Thread(oneTask);
        oneThread.start();
        String s = oneTask.get();
        System.out.printf("s:"+s);

    }
}
