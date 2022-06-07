package com.dyh.test.design_mode.strategy.exam.school;

import com.dyh.test.design_mode.strategy.exam.interfaces.School;

/**
 * description: 单校
 * author: dyh
 * date: 2022/6/7 11:24
 */
public class SingleSchool implements School {

    @Override
    public int accessSchool() {
        System.out.println("获取单个学校...");
        return 1;
    }
}
