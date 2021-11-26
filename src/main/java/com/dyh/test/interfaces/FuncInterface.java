package com.dyh.test.interfaces;

//Java 8添加一个新的包"java.util.function"，通常用于lambda表达式和方法引用，包下有很多通用接口：
import java.util.function.*;

/**
 * 函数式接口(Functional Interface)是只有一个抽象方法的接口。
 *
 * 函数式接口中的抽象函数就是为了支持 lambda表达式；
 * 函数式接口可以被隐式转换为lambda表达式；
 * 为确保函数式接口符合语法，可以添加@FunctionalInterface注解；
 */
@FunctionalInterface
public interface FuncInterface {

    //只有一个抽象方法
    public void reference();
	
	//还可以有其他方法
    //interface default method
    default void defaultMehtod() {
        System.out.println("This is a default method~");
    }

    //interface second default method
    default void anotherDefaultMehtod() {
        System.out.println("This is the second default method~");
    }

    //interface static method
    static void staticMethod() {
        System.out.println("This is a static method~");

    }

    //interface second static method
    default void anotherStaticMethod() {
        System.out.println("This is the second static method~");
    }
}
