package com.dyh.test.test.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * description: lambda常用到的
 * author: dyh
 * date: 2022/11/14 14:19
 */
public class LambdaCommonDemo {

    public static void main(String[] args) {
        //根据分隔符转List
        System.out.println(Arrays.asList("3040069735337984".split(","))
                .stream().collect(Collectors.mapping(Long::valueOf, Collectors.toList())));

    }
}
