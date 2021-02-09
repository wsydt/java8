package com.wsy.java8.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                10, 5000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                (r, executor) -> System.out.println("reject : " + r + ", executor : " + executor));

        for (int i = 0; i < 1000; i++) {
            int n = i;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("task " + n + "complete !");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
