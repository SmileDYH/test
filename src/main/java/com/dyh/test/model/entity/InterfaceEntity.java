package com.dyh.test.model.entity;

import com.dyh.test.common.B;

/**
 * 接口类实体
 * description: dyh
 * author: Administrator
 * date: 2021/3/25 0025 11:18
 */
public class InterfaceEntity implements B {

    @Override
    public void cat(){
        System.out.println("InterfaceEntity cat...");
    }


    @Override
    public void dog(){
        System.out.println("InterfaceEntity dog...");
    }
}
