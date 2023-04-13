package com.dyh.test.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * description: Stream主方法
 * author: dyh
 * date: 2023/2/28 17:35
 */
public class StreamDemoMain {

    public static void main(String[] args) {
        //Stream接口，提供了各种聚合操作的方法
        //例如：filter()方法，入参是Predicate（所有的接口入参都是四大函数），返回值是Stream接口，很多接口提供ToInt、ToLong等（所以四大函数也提供）
        Stream.of(new ArrayList<>()); //提供的静态方法

        List<String> list = new ArrayList<>();
        //Collection接口有一个默认方法default stream()，所以所有的集合类都可以使用stream流来做聚合操作（也就是继承了Collection的）；
        // 返回的是一个Stream类，可以使用Stream的所有方法；
        list.stream();
        //parallelStream 并行/并发
        list.parallelStream();

    }
}
