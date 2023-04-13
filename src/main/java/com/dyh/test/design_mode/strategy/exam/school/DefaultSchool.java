package com.dyh.test.design_mode.strategy.exam.school;

import com.dyh.test.design_mode.strategy.exam.interfaces.School;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 默认学校
 * author: dyh
 * date: 2022/6/7 11:21
 */
public class DefaultSchool implements School {

    @Override
    public List<Integer> accessSchool() {
        System.out.println("获取所有学校...");
        return new ArrayList<>(5);
    }
}
