package com.dyh.test.abstract_class;

/**
 * description:抽象类demo
 * author: dyh
 * date: 2023/1/9 11:43
 */
//默认default, 写法public abstract/abstract public
abstract class AbstractClassDemo {

    protected int x;
    private int y;

    /**
     * 需要子类具体实现，默认就是public
     */
    abstract void func1();

    /**
     * 访问权限设置成private 或者 final，防止其他方法重写；
     *  private默认是final的
     */
    private void func2(){
        System.out.println("func2");
    }

    /**
     * 钩子方法，声明并实现（空实现或者定义相关内容皆可），继承此抽象类的子类可扩展实现或者不实现；
     * 相当于预先提供了一个默认配置
     * 源自于 模板方法设计模式
     */
    public void hookMethod(){
        //可定义一个默认操作，或者为空
    };

    /**
     * 默认方法（扩展方法只能在接口中使用）
     * Extension methods can only be used within an interface
     */
//    default void defaultMethod(){
//
//    };

}
