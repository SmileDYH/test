package com.dyh.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * description:异步编程
 * author: dyh
 * date: 2022/7/19 14:22
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CompletableFuture<List<String>> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println();
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            return new ArrayList();
        });
    }
}
