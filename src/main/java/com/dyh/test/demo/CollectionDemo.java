package com.dyh.test.demo;

import java.util.*;

/**
 * Collection 和 Collections的demo
 * Collection 集合接口，在Java类库中有很多具体的实现。
 * 此接口的意义是为各种具体的集合提供最大化的统一操作方式。
 * Collections 包装类，包含各种有关集合操作的静态多态方法。
 * 此类不能实例化，就像一个工具类，服务于Java的Collection框架。
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        CollectionTest();
        CollectionsTest();
    }

    private static void CollectionTest(){
//        Collection
        List<String> list = new ArrayList<>();
        list.isEmpty();//判断是否为空
        System.out.println(list.isEmpty());

//        Queue
    }

    private static void CollectionsTest(){
        ///创建空对象, emptySet()、emptyMap()方法同理。
        Collections.emptyList();

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        ///批量添加
        Collections.addAll(arrayList, 10,18);
        System.out.println(arrayList);

        ///排序
        //反转集合中的元素
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        //按照自然顺序排序
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //随机排序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        //交换集合中的首位元素
        Collections.swap(arrayList, 0, arrayList.size()-1);
        System.out.println(arrayList);

        ///查找、替换
        // 获取集合中的最大值
        Integer max = Collections.max(arrayList);
        System.out.println(max);
        // 获取集合中的最小值
        Integer min = Collections.min(arrayList);
        System.out.println(min);
        // 替换集合中的元素
        Collections.replaceAll(arrayList, 9, 8);
        System.out.println(arrayList);
        // 二分法查找
        Collections.sort(arrayList);
        System.out.println(arrayList);
        int index=Collections.binarySearch(arrayList, 7);
        System.out.println(index);
    }
}
