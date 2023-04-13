package com.dyh.test.thread;

import com.dyh.test.basics.classs.C;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * description: 延迟线程池ScheduledExecutorService Demo
 * author: dyh
 * date: 2023/2/19 14:49
 */
@Slf4j
public class ScheduledExecutorServiceDemo {

    private static final int CORE_POOL_SIZE = 10;
    private static final int DELAY = 1000;
    private static final int PERIOD = 2000;

    public static void main(String[] args) {
        //模仿nacos，返回守护线程
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
//                thread.setDaemon(true);
                thread.setName("com.alibaba.nacos.naming.beat.sender");
                return thread;
            }
        };
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("callable...");
                return "callable";
            }
        };
        Runnable delayRunnable = new DelayRunnable();
        Runnable fixedRateRunnable = new FixedRateRunnable();


        //继承了ExecutorService，核心方法schedule()、scheduleAtFixedRate周期、scheduleWithFixedDelay延迟，后两个相当于定时
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        //继承了ThreadPoolExecutor，实现了ScheduledExecutorService
        //最多可以手动设定三个参数，corePoolSize核心线程数、threadFactory线程工厂、RejectedExecutionHandler决绝策略，其他参数都有默认值
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                new ScheduledThreadPoolExecutor(CORE_POOL_SIZE, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        //延迟delay秒执行一次，只执行一次
        Future<String> future = scheduledThreadPoolExecutor.schedule(callable, DELAY, TimeUnit.MILLISECONDS);
        try {
            future.get();
        }catch (Exception e){ }
        //延迟delay秒执行一次，之后每过period秒执行一次（定时任务），不管上一个任务是否执行完（固定速率 启动线程），可能会阻塞线程
        scheduledThreadPoolExecutor.scheduleAtFixedRate(delayRunnable, DELAY, PERIOD, TimeUnit.MILLISECONDS);
        //延迟delay秒执行一次，之后每过period秒执行一次（定时任务），等待上一个任务是否执行完（延迟执行 启动线程）
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(fixedRateRunnable, DELAY, PERIOD, TimeUnit.MILLISECONDS);

    }

    //匿名内部类，Runnable
    private static class DelayRunnable implements Runnable {
        @Override
        public void run() {
            log.info("delayRunnable...");
            try{
                Thread.sleep(3000);
            }catch (Exception e){}
        }
    }

    private static class FixedRateRunnable implements Runnable {
        @Override
        public void run() {
            log.info("fixedRateRunnable...");
            try{
                Thread.sleep(3000);
            }catch (Exception e){}
        }
    }
}
