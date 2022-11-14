package com.dyh.test.test.demo;

/**
 * description: 典型例子
 * author: dyh
 * date: 2022/11/14 14:24
 */
public class CaseDemo {

    public static void main(String[] args) {
        //i++ 与 ++i
        Integer i = 0;
        System.out.println(i++); //结果是 0
        System.out.println(++i); //结果是 2 i=i+1;
        System.out.println(i); //结果是 2

        //Long.equals(Integer)，源码中会先通过instanceof判断类型
        Long a = 1L;
        Integer b = 1;
        System.out.println(a.equals(b));


    }
}
