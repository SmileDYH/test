package com.dyh.test.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * description: 创建流的几种方式
 * author: dyh
 * date: 2021/10/20 11:24
 */
public class CreateStreamDemo {

    public static void main(String[] args) {
        String[] dd = { "a", "b", "c" };
        Arrays.stream(dd).forEach(System.out::print);// abc ①
        System.out.println();
        Stream.of(dd).forEach(System.out::print);// abc ②
        System.out.println();
        Arrays.asList(dd).stream().forEach(System.out::print);// abc ③
        System.out.println();
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::print);// 0123456789 ④
        System.out.println();
        Stream.generate(() -> "x").limit(10).forEach(System.out::print);// xxxxxxxxxx ⑤
    }
}
