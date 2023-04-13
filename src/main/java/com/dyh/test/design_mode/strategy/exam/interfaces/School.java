package com.dyh.test.design_mode.strategy.exam.interfaces;

import java.util.List;

/**
 * description:分组分校 接口
 * author: dyh
 * date: 2022/6/7 11:15
 */
public interface School {

    //提供接口，获取学校下的学生
    List<Integer> accessSchool();
}
