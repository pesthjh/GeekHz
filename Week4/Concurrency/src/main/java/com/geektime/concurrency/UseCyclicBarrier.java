package com.geektime.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrier {
    static volatile  Integer res = null;
    static CyclicBarrier barrier = new CyclicBarrier(2);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new CountDownLatchSub()).start();
        barrier.await();
        System.out.println("子线程结果:"+res);
    }
    static class CountDownLatchSub implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                res = 1;
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
