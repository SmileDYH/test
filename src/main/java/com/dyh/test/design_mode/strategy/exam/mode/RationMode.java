package com.dyh.test.design_mode.strategy.exam.mode;

import com.dyh.test.design_mode.strategy.exam.interfaces.Mode;

/**
 * description: 定量模式
 * author: dyh
 * date: 2022/6/7 11:26
 */
public class RationMode implements Mode {

    @Override
    public void allocation() {
        System.out.println("定量分配...");
    }
}
