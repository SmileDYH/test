package com.dyh.test.design_mode.strategy;

/**
 * 策略实现类
 */
public class GearStrategyOne implements GearStrategy {

    @Override
    public void algorithm(String param) {
        System.out.println("当前档位" + param);
    }
}