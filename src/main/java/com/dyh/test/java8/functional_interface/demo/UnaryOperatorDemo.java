package com.dyh.test.java8.functional_interface.demo;

import java.util.function.UnaryOperator;

/**
 * description: UnaryOperator(一元运算符) demo
 * author: dyh
 * date: 2021/11/5 14:32
 */
public class UnaryOperatorDemo {

    public static void main(String[] args) {
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(10));// 11
        UnaryOperator<String> ddb = x -> x + 1;
        System.out.println(ddb.apply("aa"));// aa1
    }
}
