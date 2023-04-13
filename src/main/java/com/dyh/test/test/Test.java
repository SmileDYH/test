package com.dyh.test.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 写程序时，测试用，每次删除
 * description: dyh
 * author: Administrator
 * date: 2020/11/16 0016 13:27
 */
public class Test {

    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(217);

        System.out.println(        sum.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP));
    }

}

