package com.dyh.test.design_mode.strategy.exam;

import com.dyh.test.design_mode.strategy.exam.interfaces.Mode;
import com.dyh.test.design_mode.strategy.exam.interfaces.Review;
import com.dyh.test.design_mode.strategy.exam.interfaces.School;
import com.dyh.test.design_mode.strategy.exam.mode.AverageMode;
import com.dyh.test.design_mode.strategy.exam.review.SingleReview;
import com.dyh.test.design_mode.strategy.exam.school.DefaultSchool;

import java.util.List;
import java.util.Map;

/**
 * description:第一版Context
 * author: dyh
 * date: 2022/6/7 11:34
 */
public class AExam extends Exam{

    /**
     * 无参构造函数，主要用于在子类创建对象时使用，java程序在执行子类的构造方法之前，会去调用父类构造方法，
     * 可以显示的指定super()某一个父类构造函数，如未显示指定 super()，系统会自动调用父类中没有参数的构造方法。
     * 所以super()没有调用父类有参构造的话，父类必须有无参构造，要不然编译会报错
     */
    //无参构造，要不然不能new
    public AExam() {
        //需要new默认参数，要不然属性是空的（null），调用时会报错
        super(new DefaultSchool(), new AverageMode(), new SingleReview());
    }

    public AExam(School school, Mode mode, Review review) {
        super(school, mode, review);
    }

    @Override
    public List<Integer> accessSchool() {
       return school.accessSchool();
    }

    @Override
    public void allocation() {
        mode.allocation();
    }

    @Override
    public Map<Integer, String> accessTeacher() {
        return review.accessTeacher();
    }
}
