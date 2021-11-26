package com.dyh.test.test;

import com.alibaba.fastjson.JSON;
import com.dyh.test.constant.ConfigConstant;
import com.dyh.test.module.LevelSetBean;
import com.dyh.test.pojo.ExamScoreAvgDto;
import com.dyh.test.pojo.ExamScoreDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * description:
 * author: dyh
 * date: 2021/11/2 14:00
 */
public class Test1 {

    public static void main(String[] args) {
        List<LevelSetBean> levelSet = ConfigConstant.ReprotCommonConfig.LEVEL_SET;
        System.out.println(levelSet);

        Integer i = new Integer("10");
        Integer.toString()
//        Collectors
//        Optional
//        CompletableFuture

    }

}
