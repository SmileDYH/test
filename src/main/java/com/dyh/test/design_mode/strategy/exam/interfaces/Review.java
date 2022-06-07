package com.dyh.test.design_mode.strategy.exam.interfaces;

import java.util.Map;

/**
 * description: 单双评 接口
 * author: dyh
 * date: 2022/6/7 11:16
 */
public interface Review {

    //提供接口，获取老师
    Map<Integer, String> accessTeacher();
}
