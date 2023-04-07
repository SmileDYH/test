package com.dyh.test.test.demo;

import com.dyh.test.utils.EmptyUtil;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * description: lambda常用到的
 * author: dyh
 * date: 2022/11/14 14:19
 */
public class LambdaCommonDemo {

    public static void main(String[] args) {
        //根据分隔符转List
        System.out.println(Arrays.asList("3040069735337984,3040069735337985".split(","))
                .stream().collect(Collectors.mapping(Long::valueOf, Collectors.toList())));

        //AtomicReference
        AtomicReference<String> answer = new AtomicReference<>("");
        if (!EmptyUtil.isEmpty(answer.get())) {
            System.out.println("111");
        }
    }
}
