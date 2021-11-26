package com.dyh.test.design_mode.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式测试类
 */
public class Context {
  // 缓存所有的策略，当前是无状态的，可以共享策略类对象
    private static final Map<String, GearStrategy> strategies = new HashMap<>();

    // 第一种写法
    static {
        strategies.put(GearType.ONE.getCode(), new GearStrategyOne());
        strategies.put(GearType.TOW.getCode(), new GearStrategyTow());
    }

    public static GearStrategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }

    // 第二种写法
    public static GearStrategy getStrategySecond(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if (type.equals(GearType.TOW.getCode())) {
            return new GearStrategyTow();
        }
        return null;
    }

}