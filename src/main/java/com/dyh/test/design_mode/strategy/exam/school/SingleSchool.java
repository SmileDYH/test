package com.dyh.test.design_mode.strategy.exam.school;

import com.dyh.test.design_mode.strategy.exam.interfaces.School;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 单校
 * author: dyh
 * date: 2022/6/7 11:24
 */
public class SingleSchool implements School {

    @Override
    public List<Integer> accessSchool() {
        System.out.println("获取单个学校...");
        return new ArrayList<>(1);
    }
}
