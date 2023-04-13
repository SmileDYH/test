package com.dyh.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * description: callable Demo
 * 参考网址：https://blog.csdn.net/qq_49529172/article/details/124218967
 * author: dyh
 * date: 2023/2/17 14:59
 */
public class CallableDemo {

    public static void main(String[] args) {
        UseCallable useCallable = new UseCallable();
        //FutureTask执行和接收的功能，继承了Runnable, Future，所以可以run()和get()，并且入参可以传入Callable（传入Runnable没有返回值）
        FutureTask<Integer> futureTask = new FutureTask<>(useCallable);

        futureTask.run();
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        }catch (Exception e){}

    }

    //匿名内部类，实现Callable接口
    private static class UseCallable implements Callable<Integer> {
        private int sum;
        @Override
        //call方法可以抛异常，像线程里面的run方法最多只能在run方法内trycatch
        public Integer call() throws Exception {
            //所需要实现的功能代码
            System.out.println(sum);
            return ++sum;
        }
    }
}
