package com.dyh.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * description: thread Demo
 * author: dyh
 * date: 2023/2/17 16:25
 */
@Slf4j
public class ThreadDemo {

    /**
     * 三种使用线程的方法 Thread、Callable、Runnable
     * Thread实现了Runnable接口
     *
     * 实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过 Thread 来调用。
     *  可以说任务是通过线程驱动从而执行的。
     *
     * 实践是检验真理的唯一标准，所以要动手写代码，动手试，先回用才能去理解原理及源码
     * @param args
     */
    public static void main(String[] args) {

        //通过本地方法start0，启动一个线程
        Thread thread = new Thread();
        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread-Runnable...");
                log.info("Thread-Runnable...");//子线程
            }
        }).start();
        log.info("Thread");//主线程
        System.out.println("--------------- Thread ----------------");

        //就是一个函数接口，一个run方法，没人实现它啥也不是，我理解就是一种规范
        //可以通过以下这种方式？？？，也可以通过lambda表达式实现
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable...");
            }
        };
        runnable = () -> log.info("runnable");//Lambda表达式
        runnable = () -> log.info("runnable");//主线程
        try {
            Thread.sleep(3000);
        }catch (Exception e){}
        runnable.run();
        System.out.println("------------- Runnable ------------------");

        //和Runnable同理，一个函数式接口，一个call方法，不同的是有返回值，并可以抛出异常，实现方式也相同
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable");
                return null;
            }
        };
        callable = () ->{return "callable";};//Lambda表达式，重写了call()方法
        try {
            System.out.println(callable.call());
        }catch (Exception e){ }
        System.out.println("-------------- Callable -----------------");

    }
}
