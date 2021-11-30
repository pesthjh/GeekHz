package com.geektime.concurrency;

import java.util.concurrent.BrokenBarrierException;

public class UseWaitAndNotify {
    static volatile  Integer res = null;
    static final Object lock = new Object();
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new CountDownLatchSub()).start();
        synchronized (lock){
            lock.wait();
        }
        System.out.println("子线程结果:"+res);
    }
    static class CountDownLatchSub implements Runnable {


        @Override
        public void run() {
            try {
                Thread.sleep(100);
                res = 1;
                synchronized (lock){
                    lock.notify();
                }

            } catch (InterruptedException  e) {
                e.printStackTrace();
            }

        }
    }
}