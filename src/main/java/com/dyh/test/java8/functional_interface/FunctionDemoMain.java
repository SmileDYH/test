package com.dyh.test.java8.functional_interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * description: 四大函数式接口
 * Consumer、Supplier、Function、Predicate（消费、生产、函数/功能、断言）
 * 消费型接口、供给型接口、函数型接口、断定型接口
 * void accapt(T t)、T get()、R apply(T t)、boolean test(T t)
 * author: dyh
 * date: 2023/2/27 15:10
 */
public class FunctionDemoMain {

    public static void main(String[] args) {
        //函数型接口，void accapt(T t)，有入参出参
        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                System.out.println("Function...");
                return "Function" + " + " + o;
            }
        };
        String s = (String) function.apply("function");//应用/申请
        System.out.println(s);
//        Function functionLambda = ("function") -> {return "Function";};//lambda
        Function function1 = Function.identity();//返回自己本身
        System.out.println("----------------------------------");


        //断定型接口，boolean test(T t)，判断
        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                System.out.println("Predicate...");
                return o.equals("Predicate");
            }
        };
        boolean b = predicate.test("predicate");//测试
        System.out.println(b);
        System.out.println("----------------------------------");


        //消费型接口，R apply(T t)，有入参，没有返回值
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("Consumer...");
                System.out.println(o);
            }
        };
        consumer.accept("consumer");//接收
        System.out.println("----------------------------------");


        //供给型接口，T get()，没有入参，有返回值
        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                System.out.println("Supplier...");
                return "Supplier";
            }
        };
        String ss = (String) supplier.get();//获取
        System.out.println(ss);
        System.out.println("----------------------------------");

    }
}
