package com.dyh.test.constant;

import com.dyh.test.model.LevelSetBean;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * Description: 静态工厂
 * Created by bq.ren on 2021/10/8.
 */
public class ConfigConstant {


    /**
     * 常用报表分析设置常量
     */
    public static class ReprotCommonConfig {

        /**
         * 学科分数 - 等级设置
         */
        public static final List<LevelSetBean> LEVEL_SET = Lists.newArrayList();


        static {
            LEVEL_SET.add(new LevelSetBean("不及格", 0, 60));
            LEVEL_SET.add(new LevelSetBean("合格", 60, 75));
            LEVEL_SET.add(new LevelSetBean("良好", 75, 90));
            LEVEL_SET.add(new LevelSetBean("优秀", 90, 100));
        }


    }


}
