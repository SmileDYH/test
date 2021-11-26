package com.dyh.test.entity;

import com.dyh.test.common.A;
import com.dyh.test.common.B;

/**
 * 抽象类实体
 * description: dyh
 * author: Administrator
 * date: 2021/3/25 0025 10:53
 */
public class AbstractEntity extends A implements B{

    @Override
    public void fish(){
        System.out.println("AbstractEntity fish...");
    }

    //父类实现了，所以可以不实现
//    @Override
//    public void cat(){
//        System.out.println("AbstractEntity cat...");
//    }

    @Override
    public void dog(){
        System.out.println("AbstractEntity dog...");
    }
}
