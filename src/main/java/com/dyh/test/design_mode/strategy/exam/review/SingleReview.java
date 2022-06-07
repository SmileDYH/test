package com.dyh.test.design_mode.strategy.exam.review;

import com.dyh.test.design_mode.strategy.exam.interfaces.Review;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 单评
 * author: dyh
 * date: 2022/6/7 13:53
 */
public class SingleReview implements Review {

    @Override
    public Map<Integer, String> accessTeacher() {
        System.out.println("获取单评老师...");
        return new HashMap<>();
    }
}
