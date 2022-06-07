package com.dyh.test.design_mode.strategy.exam.school;

import com.dyh.test.design_mode.strategy.exam.interfaces.School;

/**
 * description: 默认学校
 * author: dyh
 * date: 2022/6/7 11:21
 */
public class DefaultSchool implements School {

    @Override
    public int accessSchool() {
        System.out.println("获取所有学校...");
        return 5;
    }
}
