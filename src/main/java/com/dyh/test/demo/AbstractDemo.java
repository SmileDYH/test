package com.dyh.test.demo;

import com.dyh.test.entity.AbstractEntity;
import com.dyh.test.entity.InterfaceEntity;

/**
 * 抽象的demo（抽象类和接口）
 * description: dyh
 * author: Administrator
 * date: 2021/3/25 0025 11:13
 */
public class AbstractDemo {

    public static void main(String[] args) {
        AbstractEntity entity = new AbstractEntity();
        entity.dog();
        entity.cat();
        entity.fish();
        InterfaceEntity entity1 = new InterfaceEntity();
        entity1.dog();
        entity1.cat();
    }
}
