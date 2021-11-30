package com.geektime.concurrency;

import java.util.concurrent.Semaphore;

public class UseSemaphore {
    static volatile  Integer res = null;
    static Semaphore semaphore = new Semaphore(0);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new SemaphoreSub()).start();
        semaphore.acquire();
        System.out.println("子线程结果:"+res);
    }
    static class SemaphoreSub implements Runnable {


        @Override
        public void run() {
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res = 1;
            semaphore.release();

        }
    }
}