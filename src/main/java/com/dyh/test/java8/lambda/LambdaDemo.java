package com.dyh.test.java8.lambda;

import lombok.Data;

import java.util.Comparator;
import java.util.function.*;

/**
 * description: lambda表达式，方法的引用以及构造器的引用
 *              lambda表达式中，使用的都是函数式接口
 * author: dyh
 * date: 2021/9/30 11:45
 */
public class LambdaDemo {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        /*************** 方法的引用 ****************/
        // 类：：静态方法名
        Comparator<Integer> bb = Integer::compare;
        System.out.println(bb.compare(3, 2));
        Comparator<Integer> cc = (x, y) -> Integer.compare(x, y);
        System.out.println(cc.compare(3, 2));

        Comparator<Integer> dd = (x, y) -> x.compareTo(y);
        System.out.println(dd.compare(3, 2));
        Comparator<Integer> ee = Integer::compareTo;
        System.out.println(ee.compare(3, 2));
        // 类：：实例方法名
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("a", "b"));
        BiPredicate<String, String> bp1 = String::equals;
        System.out.println(bp1.test("a", "b"));

        // 对象：：实例方法名
        Consumer<String> con1 = x -> System.out.println(x);
        con1.accept("abc");
        Consumer<String> con = System.out::println;
        con.accept("abc");

        Emp emp = new Emp("上海", "xiaoMIng", 18);
        Supplier<String> supper1 = () -> emp.getAddress();
        System.out.println(supper1.get());
        Supplier<String> supper = emp::getAddress;
        System.out.println(supper.get());

        /*************** 构造器的引用 ****************/
        // 无参构造函数，创建实例
        Supplier<Emp> supper2 = () -> new Emp();
        Supplier<Emp> supper3 = Emp::new;
        Emp emp1 = supper3.get();
        emp1.setAddress("上海");
        // 一个参数
        Function<String, Emp> fun = address -> new Emp(address);
        Function<String, Emp> fun1 = Emp::new;
        System.out.println(fun1.apply("beijing"));
        // 两个参数
        BiFunction<String, Integer, Emp> bFun = (name, age) -> new Emp(name, age);
        BiFunction<String, Integer, Emp> bFun1 = Emp::new;
        System.out.println(bFun1.apply("xiaohong", 18));

    }

    @Data
    static class Emp {
        private String address;

        private String name;

        private Integer age;


        public Emp() {

        }

        public Emp(String address) {
            this.address = address;
        }

        public Emp(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Emp(String address, String name, Integer age) {
            super();
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Emp [address=" + address + ", name=" + name + ", age=" + age + "]";
        }

    }
}
