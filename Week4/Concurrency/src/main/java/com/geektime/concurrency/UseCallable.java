package com.geektime.concurrency;


import java.util.concurrent.*;

public class UseCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> submit = service.submit(new CallableSub());
        service.shutdown();
        Integer res =submit.get();
        System.out.println("子线程结果:"+res);
    }
    static class CallableSub implements Callable<Integer > {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(100);
            return 1;
        }
    }
}