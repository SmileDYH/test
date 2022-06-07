package com.dyh.test.java8;

import com.dyh.test.model.pojo.ExamScoreAvgDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 函数式编程，常用 复杂 demo
 * author: dyh
 * date: 2021/11/5 14:34
 */
public class Demo {

    public static void main(String[] args) {
        //分组后 再次分组
        List<ExamScoreAvgDto> list = new ArrayList<>();
        list.add(ExamScoreAvgDto.builder().areaName("1").className("a").build());
        list.add(ExamScoreAvgDto.builder().areaName("2").className("b").build());
        Map<String , Map<String ,List<ExamScoreAvgDto>>> map = list.stream()
                .collect(Collectors.groupingBy(ExamScoreAvgDto::getAreaName, HashMap::new, Collectors.groupingBy(ExamScoreAvgDto::getClassName)));
        System.out.println(map.get("1").get("a").size());
    }
}
