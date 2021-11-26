package com.dyh.test.demo;

import com.alibaba.fastjson.JSON;
import com.dyh.test.pojo.ExamScoreAvgDto;
import com.dyh.test.pojo.ExamScoreDto;

/**
 * description:
 * author: dyh
 * date: 2021/11/5 14:29
 */
public class BeanUtilsDemo {

    public static void main(String[] args) {
        ExamScoreAvgDto a = new ExamScoreAvgDto();
        a.setClassName("a");
        ExamScoreDto b = new ExamScoreDto();
        org.springframework.beans.BeanUtils.copyProperties(a, b);
        b.setClassName("aaa");
        System.out.println(JSON.toJSONString(b.getClassName()));
        System.out.println(JSON.toJSONString(a.getClassName()));
    }
}
