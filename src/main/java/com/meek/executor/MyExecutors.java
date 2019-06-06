package com.meek.executor;

import java.util.concurrent.Executors;

public class MyExecutors {
    public static void main(String[] args){
        //处理短时间工作任务,无任务不消耗什么资源(可以设置闲置时间),没有线程则会创建
        Executors.newCachedThreadPool();
        //创建指定数目的线程池
        Executors.newFixedThreadPool(8);
        //创建只有一个线程的线程池
        Executors.newSingleThreadExecutor();
        //创建周期执行的定时的线程池
        Executors.newSingleThreadExecutor();
        //支持工作窃取的线程池
        Executors.newWorkStealingPool();
    }
}
