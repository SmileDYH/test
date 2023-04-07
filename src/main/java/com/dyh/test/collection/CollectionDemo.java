package com.dyh.test.collection;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * description:
 * author: dyh
 * date: 2023/3/28 11:49
 */
public class CollectionDemo {

    public static void main(String[] args) {
        //Collection集合接口三大类 List、Set、Queue，继承了Iterator，都有迭代器
        //所有的集合类都遵循 继承抽象类（例如：AbList，作用是把通用的方法实现抽出来），实现接口（例如：List，作用是统一方法）
        List list = new ArrayList();//Vector、LinkedList不常用
        list.size();
        list.iterator().next();
//        LinkedList
//        Vector
        List copyOnWriteArrayList = new CopyOnWriteArrayList();//线程安全
        Set set = new HashSet();//不重复
        Set treeSet = new TreeSet<Integer>();//使用TreeSet建议加上泛型，以保证集合中的元素一致
        Queue queue = new LinkedBlockingQueue(10);

        //Map集合
        Map map = new HashMap();//Hashtable、LinkedHashMap不常用
//        Hashtable
        Map treeMap = new TreeMap();//有序
        Map concurrentHashMap = new ConcurrentHashMap();//线程安全
    }
}
