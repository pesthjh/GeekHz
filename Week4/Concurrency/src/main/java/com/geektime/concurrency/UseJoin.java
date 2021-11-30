package com.geektime.concurrency;

public class UseJoin {
    static volatile  Integer res = null;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new CountDownLatchSub());
        thread.start();
        thread.join();
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


        }
    }
}