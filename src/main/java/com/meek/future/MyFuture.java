package com.meek.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java异步调用
 */
public class MyFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        System.out.println(future.get());
        System.out.println("finish");
    }
}
