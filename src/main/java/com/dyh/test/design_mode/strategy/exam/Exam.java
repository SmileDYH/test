package com.dyh.test.design_mode.strategy.exam;

import com.dyh.test.design_mode.strategy.exam.interfaces.Mode;
import com.dyh.test.design_mode.strategy.exam.interfaces.Review;
import com.dyh.test.design_mode.strategy.exam.interfaces.School;

import java.util.Map;

/**
 * description:考试阅卷 抽象类
 * （抽象类把几个接口封装起来了，提供了多个属性的多个策略/方法，类似于一个大接口把小接口当成了属性）
 * author: dyh
 * date: 2022/6/7 11:14
 */
public abstract class Exam {

//    public Exam() {}

    //有参构造
    public Exam(School school, Mode mode, Review review) {
        this.school = school;
        this.mode = mode;
        this.review = review;
    }

    //接口属性
    public School school;
    public Mode mode;
    public Review review;

    //抽象方法
    public abstract int accessSchool();
    public abstract void allocation();
    public abstract Map<Integer, String> accessTeacher();

    //属性提供get、set方法
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
