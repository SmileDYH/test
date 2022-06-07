package com.dyh.test.design_mode.strategy.exam.mode;

import com.dyh.test.design_mode.strategy.exam.interfaces.Mode;

/**
 * description: 平均模式
 * author: dyh
 * date: 2022/6/7 11:26
 */
public class AverageMode implements Mode {

    @Override
    public void allocation() {
        System.out.println("平均分配...");
    }
}
