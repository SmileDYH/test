package com.dyh.test.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description: Stream接口实现demo
 * author: dyh
 * date: 2021/10/24 11:00
 */
public class StreamDemo {

    public static void main(String[] args) {
        //reduce 是一种归约操作，将流归约成一个值的操作叫做归约操作，用函数式编程语言的术语来说，这种称为折叠（fold）；
        reduce();
        //collect 收集器操作[聚合操作]：可以当做是一种更高级的归约操作；
        collect();

        //sorted排序
        sorted();
    }

    /**
     * JDK中对identity的说明：
     *         identity必须是accumulator函数的一个identity，也就是说必须满足：对于所有的t,都必须满足 accumulator.apply(identity, t) == t
     *         因为sum（100+1）！= 1。
     *         所以多线程下这里sum方法的identity只能是0。
     */
    static void reduce(){
        //使用无限流，生成1-10的数字的list
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
        //java8之前，我们对数据求和的，是需要对list进行遍历，然后累加求和的；
        Integer aa = 0;
        for (Integer i : numbers) {
            aa += i;
        }
        //java8中的求和方式.
        //这个函数，接受2个参数，第一个表示初始值（多线程下不同），第二个值，传入的是一个函数式接口BinaryOperator，这个接口继承BiFunction;计算的表达式的规则；
        Integer bb = numbers.parallelStream().reduce(0, (a, b) -> a + b);
        //这个函数，接受3个参数，感觉和接受两个参数一样，比较鸡肋，第三个参数实际意义：
        // BinaryOperator是供多线程使用的，如果不在Stream中声明使用多线程，就不会使用子任务，自然也不会调用到该方法。另外多线程下使用BinaryOperator的时候是需要考虑线程安全的问题。
        //参考https://segmentfault.com/q/1010000004944450
        Integer cc = numbers.parallelStream().reduce(0, (a, b) -> a - b, (a, b) -> a - b);//用到多线程，会合并多线程计算的结果，结果比较复杂，鸡肋
        Integer dd = numbers.stream().reduce(0, (a, b) -> a + b, (a, b) -> a - b);//用不到多线程，和两个参数一样
        //这个接口。只用传入计算规则，初始值是list的第一个参数，返回的optional对象，预防list里，全部是null；
        Optional<Integer> dd1 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(dd);
        System.out.println(dd1.get());

        //多线程下： 参考https://www.cnblogs.com/flydean/p/java-8-stream-reduce.html
        //也许在有些文章里面有人告诉你identity是reduce的初始化值，可以随便指定，如下所示：我们计算的值是106。
        List<Integer> intList = Arrays.asList(1,2,3);
        Integer result2=intList.stream().reduce(100, Integer::sum);
        System.out.println(result2);
        //如果我们将stream改成parallelStream：得出的结果就是306。因为在并行计算的时候，每个线程的初始累加值都是100，最后3个线程加出来的结果就是306。
        //因为在并行计算的时候，每个线程的初始累加值都是100，最后3个线程加出来的结果就是306。
        Integer result3=intList.parallelStream().reduce(100, Integer::sum);
        System.out.println(result3);
    }

    /**
     * 整个Collectors工具类就是在为Collector服务，用于创建各种不同的Collector。
     * 部分功能与Stream中的方法重合了，为了简化代码，完全不必采用Collectors实现，优先Stream方法。
     */
    static void collect(){
        // 转list
        List<String> names = list.stream().map(emp -> emp.getName()).collect(Collectors.toList());
        // 转set
        Set<String> address = list.stream().map(emp -> emp.getName()).collect(Collectors.toSet());
        // 转map，需要指定key和value，Function.identity()表示当前的Emp对象本身
        Map<String, Emp> map = list.stream().collect(Collectors.toMap(Emp::getName, Function.identity()));
        // 计算元素中的个数
        Long count = list.stream().collect(Collectors.counting());
        // 数据求和 summingInt summingLong，summingDouble
        Integer sumAges = list.stream().collect(Collectors.summingInt(Emp::getAge));
        // 平均值 averagingInt,averagingDouble,averagingLong
        Double aveAges = list.stream().collect(Collectors.averagingInt(Emp::getAge));

        // 综合处理的，求最大值，最小值，平均值，求和操作
        // summarizingInt，summarizingLong,summarizingDouble
        IntSummaryStatistics intSummary = list.stream().collect(Collectors.summarizingInt(Emp::getAge));
        System.out.println(intSummary.getAverage());// 19.5
        System.out.println(intSummary.getMax());// 22
        System.out.println(intSummary.getMin());// 17
        System.out.println(intSummary.getSum());// 117

        // 连接字符串,当然也可以使用重载的方法，加上一些前缀，后缀和中间分隔符
        String strEmp = list.stream().map(emp -> emp.getName()).collect(Collectors.joining());
        String strEmp1 = list.stream().map(emp -> emp.getName()).collect(Collectors.joining("-中间的分隔符-"));
        String strEmp2 = list.stream().map(emp -> emp.getName()).collect(Collectors.joining("-中间的分隔符-", "前缀*", "&后缀"));
        System.out.println(strEmp);// 小名小红小蓝小灰小黄小白
        // 小名-中间的分隔符-小红-中间的分隔符-小蓝-中间的分隔符-小灰-中间的分隔符-小黄-中间的分隔符-小白
        System.out.println(strEmp1);
        // 前缀*小名-中间的分隔符-小红-中间的分隔符-小蓝-中间的分隔符-小灰-中间的分隔符-小黄-中间的分隔符-小白&后缀
        System.out.println(strEmp2);
        // maxBy 按照比较器中的比较结果刷选 最大值
        Optional<Integer> maxAge = list.stream().map(emp -> emp.getAge())
                .collect(Collectors.maxBy(Comparator.comparing(Function.identity())));
        // 最小值
        Optional<Integer> minAge = list.stream().map(emp -> emp.getAge())
                .collect(Collectors.minBy(Comparator.comparing(Function.identity())));
        System.out.println("max:" + maxAge);
        System.out.println("min:" + minAge);

        // 归约操作
        list.stream().map(emp -> emp.getAge()).collect(Collectors.reducing((x, y) -> x + y));
        list.stream().map(emp -> emp.getAge()).collect(Collectors.reducing(0, (x, y) -> x + y));
        // 分操作 groupingBy 根据地址，把原list进行分组
        Map<String, List<Emp>> mapGroup = list.stream().collect(Collectors.groupingBy(Emp::getAddress));
        // partitioningBy 分区操作 需要根据类型指定判断分区
        Map<Boolean, List<Integer>> partitioningMap = list.stream().map(emp -> emp.getAge())
                .collect(Collectors.partitioningBy(emp -> emp > 20));
    }

    public static List<Emp> list = new ArrayList<>();
    static {
        list.add(new Emp("上海", "小名", 17));
        list.add(new Emp("北京", "小红", 18));
        list.add(new Emp("深圳", "小蓝", 19));
        list.add(new Emp("广州", "小灰", 20));
        list.add(new Emp("杭州", "小黄", 21));
        list.add(new Emp("贵阳", "小白", 22));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Emp {
        private String address;

        private String name;

        private Integer age;

        @Override
        public String toString() {
            return "Emp [address=" + address + ", name=" + name + ", age=" + age + "]";
        }
    }

    /**
     * stream流排序
     */
    static void sorted(){
        ///单字段排序
        //根据age进行排序——升序排序
        list = list.stream().sorted(Comparator.comparing(Emp::getAge)).collect(Collectors.toList());
        //根据age进行排序——降序排序
        list = list.stream().sorted(Comparator.comparing(Emp::getAge).reversed()).collect(Collectors.toList());

        ///多字段排序
        //根据age及name进行 联合升序排序
        list = list.stream().sorted(Comparator.comparing(Emp::getAge).thenComparing(Emp::getName)).collect(Collectors.toList());
        //下面两个结果都是以age降序name升序排序的结果，但是查询方式不同
        list =  list.stream().sorted(Comparator.comparing(Emp::getAge).reversed().thenComparing(Emp::getName)).collect(Collectors.toList());
        // **推荐使用该种方式**
        list =  list.stream().sorted(Comparator.comparing(Emp::getAge,Comparator.reverseOrder()).thenComparing(Emp::getName)).collect(Collectors.toList());
    }
}
