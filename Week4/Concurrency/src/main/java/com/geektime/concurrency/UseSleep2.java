package com.geektime.concurrency;

import java.util.concurrent.ExecutionException;

public class UseSleep2 {
    static volatile Integer res = null;
    static volatile boolean state = false;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new Sub()).start();
        while (!state || res == null) {
            Thread.sleep(10);
        }
        System.out.println("子线程结果:" + res);
    }

    static class Sub implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res = 1;
            state = true;
        }
    }
}