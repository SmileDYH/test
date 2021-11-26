package com.dyh.test.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier，回环栅栏，它会阻塞一组线程直到这些线程同时达到某个条件才继续执行
 * 和CountDownLatch相似但不同，CountDownLatch需要调用countDown()方法触发事件，而CyclicBarrier不需要
 * description: dyh
 * author: Administrator
 * date: 2021/3/8 0008 13:53
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println("before");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after");
            }).start();
        }
    }
}
