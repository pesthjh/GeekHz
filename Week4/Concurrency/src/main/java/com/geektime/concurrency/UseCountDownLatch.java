package com.geektime.concurrency;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
    static volatile  Integer res = null;
    static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountDownLatchSub()).start();
        latch.await();
        System.out.println("子线程结果:"+res);
    }
    static class CountDownLatchSub implements Runnable {


        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res = 1;
            latch.countDown();
        }
    }
}