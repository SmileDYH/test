package com.dyh.test.java8.functional_interface;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * description:BiConsumer demo
 * author: dyh
 * date: 2021/9/26 15:21
 */
public class BiConsumerDemo {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = x -> System.out.println("hello!" + x);
        stringConsumer.accept("cattle");
        //核心就是一个消费者，把BiConsumer形参传入值，然后输出出去
        BiConsumer<Integer, Integer> add = (x, y) -> System.out.println(Math.addExact(x, y));
        add.accept(1, 2);

        //Map.forEach例子
        //consumer当做参数例子里面，我们发现list的forEach代码参数是Consumer，而map里面的forEach参数则使用的是BiConsumer，下面我们看下例子
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Kotlin");
        map.put(3, "React");
        map.put(4, "Python");
        map.put(5, "Go");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
