package com.dyh.test.interfaces;

/**
 * 1)静态方法可以直接调用，不能被重写
 * 2)默认方法需要通过实现类，重写后实例化后调用
 */
public class CommonInterfaceImpl implements CommonInterface, CommonInterface1 {
    @Override
    public void doSomthing() {
        System.out.println("CommonInterfaceImpl.doSomthing(): 我们来学习Java8新特性吧！");
    }
    @Override
    public void defaultMehtod() {
        System.out.println("CommonInterfaceImpl.defaultMehtod()-------------start");
        CommonInterface.super.defaultMehtod();
        CommonInterface1.super.defaultMehtod();
        System.out.println("CommonInterfaceImpl.defaultMehtod()-------------end");
    }
    @Override
    public void anotherDefaultMehtod() {
        System.out.println("CommonInterfaceImpl.anotherDefaultMehtod()-------------start");
        CommonInterface.super.anotherDefaultMehtod();
        CommonInterface1.super.anotherDefaultMehtod();
        System.out.println("CommonInterfaceImpl.anotherDefaultMehtod()-------------end");
    }
}