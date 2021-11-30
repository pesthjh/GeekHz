package com.geektime.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UseCondition {
    static ReentrantLock lock = new ReentrantLock();
    static volatile  Integer res = null;
    public static void main(String[] args) throws InterruptedException {
        Condition condition = lock.newCondition();
        new Thread(new CountDownLatchSub(lock,condition)).start();
        lock.lock();
        condition.await();
        lock.unlock();
        System.out.println("子线程结果:"+res);
    }
    static class CountDownLatchSub implements Runnable {

        Condition condition;
        ReentrantLock lock;
        public CountDownLatchSub(ReentrantLock lock, Condition condition) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res = 1;
            lock.lock();
            condition.signal();
            lock.unlock();
        }
    }
}