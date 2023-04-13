package com.dyh.test.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * description: Optional类demo main
 * author: dyh
 * date: 2023/3/14 10:51
 */
public class OptionalDemoMain {

    public static void main(String[] args) {
        //供应者/生产者，函数式接口，只有一个get()方法，
        Supplier supplier = () -> {
            return null;
        };


        //创建、判断、获取 Optional
        Girl girl = new Girl();
        Girl girl1 = null;
        //Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Optional<Girl> a = Optional.of(girl);
        //Optional.ofNullable(T t)：t可以为null
        Optional<Girl> b = Optional.ofNullable(girl1);
        //Optional.empty() : 创建一个空的 Optional 实例
        Optional<Boy> c = Optional.empty();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("------------------- 创建Optional类 ------------------");

        //boolean isPresent() : 判断是否包含对象
        System.out.println("isPresent：" + a.isPresent());
        System.out.println("isPresent：" + b.isPresent());
        //void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
        a.ifPresent(Girl::setValue);
        System.out.println(a);
//        a.ifPresent(Boy::new); //暂未理解
//        System.out.println(a);
        a.ifPresent(g -> {
            g.setName("dyh");
        });
        System.out.println(a);
        System.out.println("------------------- 判断Optional容器 ------------------");

        // T get(): 如果调用对象包含值，返回该值，否则抛异常
        System.out.println("a.get(): " + a.get());
//        System.out.println(b.get()); //NoSuchElementException
        // T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
        System.out.println("a.orElse: " + a.orElse(new Girl()));
        System.out.println("b.orElse: " + b.orElse(new Girl()));
        // T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
        System.out.println("a.orElseGet: " + a.orElseGet(Girl::new).getName());
        System.out.println("b.orElseGet: " + b.orElseGet(Girl::new).getName());
        // T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。
        System.out.println("a.orElseThrow: " + a.orElseThrow(RuntimeException::new));
        b.orElseThrow(RuntimeException::new);
        System.out.println("------------------- 获取Optional容器的对象 ------------------");
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Girl {
        private String name;

        public void setValue() {
            this.name = "测试set";
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Boy {
        private Girl girl;
    }
}

