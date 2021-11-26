package com.dyh.test.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;

/**
 * description: atomic测试类
 * author: dyh
 * date: 2021/4/7 0007 15:30
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        System.out.println("addAndGet:"+i.addAndGet(10));//值相加  addAndGet:11
        System.out.println("compareAndSet:"+i.compareAndSet(11,20)+" i:"+i.intValue());//比较交换  mpareAndSet:true i:20

        AtomicLong atomicLong = new AtomicLong(555);
        LongBinaryOperator binaryOperator = (x, y) -> x * y;
        long value = atomicLong.accumulateAndGet(555, binaryOperator);//值用于函数的参数，计算出值来
        System.out.println("Updated value is " + value);//Updated value is 308025
    }
}
