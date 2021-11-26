package com.dyh.test.java8.stream;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

/**
 * Collectors工具类demo
 * description: dyh
 * author: Administrator
 * date: 2021/1/27 0027 15:18
 */
public class CollectorsDemo {

    /**
     * stream转换成集合类需要用到stream.collect方法。collect方法需要传入一个Collector类型，要实现Collector比较麻烦，需要实现好几个接口。
     * java提供了更简单的Collectors工具类来方便我们构建Collector。
     *
     * @param args
     */
    public static void main(String[] args) {

        test();
    }

    static void test() {
        List<String> list = Arrays.asList("jack", "bob", "alice", "mark");
        List<String> duplicateList = Arrays.asList("jack", "jack", "alice", "mark");

        ///.collect(Collectors.toXXX())
        //Collectors.toList() 将stream转换为list ArrayList
        //Collectors.toSet()  将Stream转换成为set HashSet

        ///上面的toMap,toSet转换出来的都是特定的类型，如果我们需要自定义，则可以使用toCollection()
        List<String> custListResult = list.stream().collect(Collectors.toCollection(LinkedList::new));//转换成了LinkedList
        System.out.println("custListResult--->" + custListResult);

        ///Collectors.toMap()    Collectors.toConcurrentMap()和map一样，只不过是线程安全的
        // Function.identity()/identity()返回自己的lambda表达式，String::length获取这个字符串的长度，mergeFunction合并相同
        Map<String, Integer> duplicateMapResult = duplicateList.stream().
                collect(Collectors.toMap(identity(), String::length, (item, identicalItem) -> item));//
        System.out.println("duplicateMapResult==》" + duplicateMapResult);

        ///Collectors.collectingAndThen()
        //collectingAndThen允许我们对生成的集合再做一次操作。
        List<String> collectAndThenResult = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    return new ArrayList<>(l);
                }));
        System.out.println("collectAndThenResult==>" + collectAndThenResult);

        ///Collectors.joining()
        //Joining用来连接stream中的元素   分界，前缀，后缀
        String joinResult = list.stream().collect(Collectors.joining(" ", "prefix","suffix"));
        System.out.println("joinResult==>"+joinResult);

        ///Collectors.counting()
        //counting主要用来统计stream中元素的个数
        Long countResult = list.stream().collect(Collectors.counting());
        System.out.println("countResult==>"+countResult);

        ///Collectors.summarizingDouble/Long/Int()
        //SummarizingDouble/Long/Int为stream中的元素生成了统计信息，返回的结果是一个统计类
        IntSummaryStatistics intResult = list.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("intResult==>"+intResult);

        //Collectors.averagingDouble/Long/Int()   求平均
        //Collectors.summingDouble/Long/Int()     求总和
        //Collectors.maxBy()/minBy()              求最大/最小

        ///Collectors.groupingBy()                GroupingBy根据某些属性进行分组，并返回一个Map
        //Collectors.partitioningBy()            根据判断条件分组，分为两组（鸡肋）
        //PartitioningBy是一个特别的groupingBy，PartitioningBy返回一个Map，这个Map是以boolean值为key，从而将stream分成两部分，一部分是匹配PartitioningBy条件的，一部分是不满足条件的
        Map<Boolean, List<String>> partitionResult = list.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println("partitionResult==>"+partitionResult);

        ///Collectors.mapping()
        //对流中的每个元素进行映射，即类型转换，然后再将新元素以给定的Collector进行归纳
        List<String> listX = Arrays.asList("123","456","789","1101","212121121","asdaa","3e3e3e","2321eew");
        List<Integer> mapping = listX.stream().limit(5).collect(Collectors.mapping(Integer::valueOf,Collectors.toList()));
        System.out.println("mapping==>"+mapping);

        ///Collectors.reducing()
        //reducing方法有三个重载方法，其实是和Stream里的三个reduce方法对应的，二者是可以替换使用的，作用完全一致，也是对流中的元素做统计归纳作用。
        System.out.println(list.stream().limit(4).map(String::length).collect(Collectors.reducing(Integer::sum)));
        System.out.println(list.stream().limit(3).map(String::length).collect(Collectors.reducing(0, Integer::sum)));
        System.out.println(list.stream().limit(4).collect(Collectors.reducing(0,String::length,Integer::sum)));


        ///总结：整个Collectors工具类就是在为Collector服务，用于创建各种不同的Collector。部分功能与Stream中的方法重合了，为了简化代码，完全不必采用Collectors实现，优先Stream方法。
    }
}
