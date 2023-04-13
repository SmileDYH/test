package com.dyh.test.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * description: 创建流的几种方式
 * author: dyh
 * date: 2021/10/20 11:24
 */
public class CreateStreamDemo {

    public static void main(String[] args) {
        //创建流总体来说三种范式：
        //Arrays类的stream()方法、Stream接口下的静态方法、继承Collection接口的所有集合类
        // 1. Arrays类的stream()方法 ①
        // 2. Stream接口下的of、iterate、generate等静态方法 ②、④、⑤
        // 3. 继承Collection接口的所有集合类（Collection默认方法stream()返回Stream对象） ③
        // 都会返回Stream对象
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

        //就是③，这样看更明显点
        List<String> list = new ArrayList<>();
        list.stream();
    }
}
