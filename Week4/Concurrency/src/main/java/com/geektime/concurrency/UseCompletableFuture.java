package com.geektime.concurrency;

import java.util.concurrent.CompletableFuture;

public class UseCompletableFuture {
    public static void main(String[] args) {
        int res = CompletableFuture.supplyAsync(UseCompletableFuture::sub).join();
        System.out.println(Thread.currentThread().getName()+":子线程结果:"+res);
    }

    private static Integer sub() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + " sub() start");
            Thread.sleep(100);
            System.out.println(name + " sub() end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}