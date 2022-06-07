package com.dyh.test.basics.classs;

/**
 * description: 继承和实现
 * author: dyh
 * date: 2022/6/6 14:40
 */
public class C extends A implements B {

    public static void main(String[] args) {
       C c = new C();
       c.c();
       c.b();
       A a = new A();
       a.a();
    }

    public void c(){
        super.a();
        this.a();
        this.b();
    }

    @Override
    public void a(){
        System.out.println("aaa");
    }

    @Override
    public void b(){
        System.out.println("bbb");
    }

}
