package com.geektime.concurrency;

import java.util.concurrent.ExecutionException;

public class UseSleep1 {
    static volatile Integer res = null;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Sub()).start();
        Thread.sleep(1000);
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
        }
    }
}
