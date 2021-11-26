package com.dyh.test.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * description: StringUtils各方法及使用
 * author: dyh
 * date: 2021/6/15 10:51
 */
public class StringUtil {

    public static void main(String[] args) {
        join();
    }

    static void join(){
        List<String> list = new ArrayList<>();
        list.add("Mxy");
        list.add("StringUtils");
        list.add("join");
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
        String join = StringUtils.join(list,"-");//传入String类型的List集合，使用"-"号拼接
        System.out.println(join);

        String[] s = new String[]{"Yuan","Mxy"};//传入String类型的数组，使用"-"号拼接
//        char[] s = new char[]{'Y','M'};//单引号，且只能一个字符
        String join2 = StringUtils.join(s,"-");
        System.out.println(join2);


        //String.join只能是实现CharSequence接口类型的集合或数组
        String joinString = String.join("-",list);//传入String类型的List集合，使用"-"号拼接
        System.out.println(joinString);

        //String.join只能是实现CharSequence接口类型的集合或数组（char不行）
        String join2String = String.join("-",s);
        System.out.println(join2String);
    }
}
