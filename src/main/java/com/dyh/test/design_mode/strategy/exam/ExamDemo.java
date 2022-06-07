package com.dyh.test.design_mode.strategy.exam;

import com.dyh.test.design_mode.strategy.exam.mode.EfficiencyMode;
import com.dyh.test.model.enums.ReviewType;

/**
 * description: 阅卷demo
 * author: dyh
 * date: 2022/6/7 11:31
 */
public class ExamDemo {

    public static void main(String[] args) {
        System.out.println("【业务】获取配置......");

        Exam exam = new AExam();
        int i =  exam.accessSchool();
        if (ReviewType.SINGLE.getCode().equals("one")){
//            System.out.println("【注释】单评方式...");
            exam.accessTeacher();
            exam.allocation();
            System.out.println("【注释】剩余部分...");
            exam.setMode(new EfficiencyMode());
            exam.allocation();
        }else if (ReviewType.DOUBLE.getCode().equals("tow")){
            System.out.println("【注释】双评方式...");
        }

        System.out.println("【业务】统一下发......");
    }
}
