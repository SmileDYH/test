package com.dyh.test.design_mode.strategy;

/**
 * description:策略实现类
 * author: dyh
 * date: 2021/6/26 10:45
 */
public class GearStrategyTow implements GearStrategy{

    @Override
    public void algorithm(String param) {
        System.out.println("当前档位" + param);
    }
}
