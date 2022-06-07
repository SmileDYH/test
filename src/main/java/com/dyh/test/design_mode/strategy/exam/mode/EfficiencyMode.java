package com.dyh.test.design_mode.strategy.exam.mode;

import com.dyh.test.design_mode.strategy.exam.interfaces.Mode;

/**
 * description: 效率模式
 * author: dyh
 * date: 2022/6/7 11:27
 */
public class EfficiencyMode implements Mode {

    @Override
    public void allocation() {
        System.out.println("效率分配...");
    }
}
