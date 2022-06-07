package com.dyh.test.basics.interfaces;

/**
 * description:
 * author: dyh
 * date: 2021/8/26 15:47
 */
public class Main {
    public static void main(String[] args) {
        //默认方法　和　抽象方法需实现类实例化后调用
        CommonInterface commonInterface = new CommonInterfaceImpl();
        //抽象方法重写后调用
        commonInterface.doSomthing();
        //默认方法重写后调用
        commonInterface.defaultMehtod();
        commonInterface.anotherDefaultMehtod();
    }
}
