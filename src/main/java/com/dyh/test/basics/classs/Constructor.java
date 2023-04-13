package com.dyh.test.basics.classs;

/**
 * description: 构造方法
 * 无参构造的作用是：初始化一个对象
 * 有参构造的作用是：实例化类中的属性
 * java类加载过程：java初始化是new对象，实例化是属性赋值，spring中的含义是完全不一样的
 * 待验证？
 * author: dyh
 * date: 2023/1/30 13:58
 */
public class Constructor {

    //构造方法不能定义返回值，带有返回值就不是构造方法了;
    //构造方法的返回值是隐式的，当使用 new 关键字来调用构造方法时，构造方法返回该类的实例；
    //构造方法可以通过private修饰，来控制此类不能new，内部定义一些静态类 或 静态方法提供给外部用;
    //构造方法不能被 static、final、synchronized、abstract 和 native（类似于 abstract）修饰；
    public Constructor(){
        System.out.println("无参构造...");
    }

    public Constructor(String a){
        //想要调用无参构造，需要手动调用；且需要在最上面调用
        this();
        System.out.println("有参构造..." + a);
    }
}
