package com.dyh.test.common;

/**
 * 抽象类（测试抽象类和接口）
 * description: dyh
 * author: Administrator
 * date: 2021/3/25 0025 10:47
 */
public abstract class A {

    //普通方法，可以做一些不是公共的东西，给子类用
    public void cat(){
        System.out.println("abstract cat...");
    }

    //需要显示表明为public，默认是default；因为子类没在同一个包下
    public abstract void fish();
}
