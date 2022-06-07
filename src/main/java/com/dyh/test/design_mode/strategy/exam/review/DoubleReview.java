package com.dyh.test.design_mode.strategy.exam.review;

import com.dyh.test.design_mode.strategy.exam.interfaces.Review;

import java.util.HashMap;
import java.util.Map;

/**
 * description:双评
 * author: dyh
 * date: 2022/6/7 13:54
 */
public class DoubleReview implements Review {

    @Override
    public Map<Integer, String> accessTeacher() {
        System.out.println("获取双评老师...");
        return new HashMap<>();
    }
}
