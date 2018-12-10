package com.meek.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁 ReentrantLock 可中断响应、锁申请等待限时、公平锁
 */
public class MyReentrantLock implements Runnable {

    //非公平锁
    public static ReentrantLock reentrantLock = new ReentrantLock(false);

    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            reentrantLock.lock();
            try {
                i++;
            }finally {
                reentrantLock.unlock();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        MyReentrantLock test = new MyReentrantLock();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();t2.start();
        t1.join(); t2.join(); // main线程会等待t1和t2都运行完再执行以后的流程
        System.err.println(i);
    }
}
