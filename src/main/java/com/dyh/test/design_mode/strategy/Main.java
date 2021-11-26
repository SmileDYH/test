package com.dyh.test.design_mode.strategy;

/**
 * description: 模板模式main方法
 * author: dyh
 * date: 2021/6/28 10:40
 */
public class Main {

    public static void main(String[] args) {
        // 测试结果
//        Context context = new Context();
//        context.getStrategy(GearType.ONE.getCode());//可以写成非静态方法，new之后去获取
        GearStrategy strategyOne = Context.getStrategy(GearType.ONE.getCode());
        if (strategyOne != null) {
            strategyOne.algorithm("1档");
            // 结果：当前档位1档
        }
        GearStrategy strategyTwo = Context.getStrategySecond(GearType.TOW.getCode());
        if (strategyTwo != null){
            strategyTwo.algorithm("2档");
            // 结果：当前档位2档
        }
    }
}
