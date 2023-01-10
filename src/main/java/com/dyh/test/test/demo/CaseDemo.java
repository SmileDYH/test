package com.dyh.test.test.demo;

import com.dyh.test.model.pojo.Ques;

import java.util.HashSet;

/**
 * description: 典型例子
 * author: dyh
 * date: 2022/11/14 14:24
 */
public class CaseDemo {

    public static void main(String[] args) {
        //i++ 与 ++i
        Integer i = 0;
        System.out.println(i++); //结果是 0
        System.out.println(++i); //结果是 2 i=i+1;
        System.out.println(i); //结果是 2
        System.out.println("----------------------");

        //Long.equals(Integer)，源码中会先通过instanceof判断类型
        Long a = 1L;
        Integer b = 1;
        System.out.println(a.equals(b));
        System.out.println("----------------------");

        //封装类（对象）的 ==、equals、hashCode，注：基本类型就是对比 值，所以只有 ==，没有equals
        //@Data重写了equals、hashCode、toString，提供get、set、无参构造函数
        //判断 是否是同一个对象、是否是同一个类、值是否相等
        //        if (this == o) return true;
        //        if (o == null || getClass() != o.getClass()) return false;
        //Object 对象基类
        Ques ques = new Ques();
        ques.setAnalyse("a");
        Ques ques1 = new Ques();
        ques1.setAnalyse("a");
        Ques ques2 = ques;

        System.out.println(ques.equals(ques1));//flash 对比对象的地址值，重写后可以对比值，@Data重写了equals
        System.out.println(ques.hashCode());//返回散列值
        System.out.println(ques1.hashCode());//equals为true,hashCode一定相等; hashCode相等,equals不一定为true
        System.out.println(ques == ques1);//flash 对比对象的地址值
        System.out.println(ques);
        System.out.println(ques1);
        System.out.println(ques2);// ques2 == ques，重写前 ques.equals(ques2)

        //HashSet的底层是将值放入map的key中去重
        HashSet<Ques> set = new HashSet<>();
        set.add(ques);
        set.add(ques1);
        System.out.println(set.size());   // 2, 这两个不是一个对象，重写equals和hashCode后为 1
        System.out.println("----------------------");
    }
}
