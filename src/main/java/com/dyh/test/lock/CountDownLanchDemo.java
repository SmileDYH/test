package com.dyh.test.lock;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLanch
 */
public class CountDownLanchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " 离开了教室...");
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("班长把门给关了，离开了教室...");
    }
}
