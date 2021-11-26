package com.dyh.test.java8.functional_interface;

import java.util.function.Consumer;

/**
 * description:Consumer(消费者) demo
 * author: dyh
 * date: 2021/9/30 14:32
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);// 12
            System.out.println(a + "_");// 12_
        };
        consumer.accept(10);
    }
}
