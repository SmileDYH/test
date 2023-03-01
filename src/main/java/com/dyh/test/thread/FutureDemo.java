package com.dyh.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * description:
 * author: dyh
 * date: 2023/2/17 17:41
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Future是 异步计算结果 的容器接口
        //核心方法是get()，获取返回值，阻塞
        Future future = new FutureTask(() -> {return null;});

        //FutureTask执行和接收的功能，继承了Runnable, Future，所以可以run()和get()，并且入参可以传入Callable（传入Runnable没有返回值）
        FutureTask futureTask = new FutureTask(() -> {return null;});
        futureTask.run();
        Object object = futureTask.get();

        try {
            //调用FutureTask使用实例
            test();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //FutureTask使用实例
    private static void test() throws ExecutionException, InterruptedException{
        //创建FutureTask,构造函数传入Callable（入参只能是Callable）
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000L);
                System.out.println("返回执行结果");
                return "test";
            }
        });
        System.out.println("等待执行结果");

        //创建线程，运行Callable内容
        // FutureTask实现了Runnable接口的run方法，重写了Callable
        futureTask.run();

        //阻塞等待FutureTask的执行结果
        String result = (String) futureTask.get();
        System.out.println("结果为:"+result);
    }

}
