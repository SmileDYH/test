package com.dyh.test.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * description: 线程池demo
 * author: dyh
 * date: 2023/2/16 17:57
 */
public class ThreadPoolDemoMain {

    private static final int CORE_POOL_SIZE = 10;
    private static final int MAXIMUM_POOL_SIZE = 100;
    private static final long KEEP_ALIVE_TIME = 1000;

    private static final int DELAY = 1000;
    private static final int PERIOD = 2000;
    /**
     * 线程、线程池 所有用到的类、方法、关键字
     */
    public static void main(String[] args) {
        ///线程
        //控制线程 Object、Thread、LockSupport、synchronized
        Object object = new Object();
        Thread t = new Thread();
        LockSupport.park();
        synchronized (object){ };

        //实现线程/三种使用线程的方法 Thread、Callable、Runnable，Thread实现了Runnable接口
        //实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过 Thread 来调用。
        // 可以说任务是通过线程驱动从而执行的。
        Thread thread = new Thread();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        runnable = () -> System.out.println("runnable");//Lambda表达式
        runnable.run();
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };
        callable = () ->{return "callable";};//Lambda表达式
        try {
            callable.call();
        }catch (Exception e){ }
        System.out.println("------------------------- 线程相关 ------------------------");


        //线程相关
        Future f = new FutureTask(callable);
        FutureTask futureTask = new FutureTask(() ->{return "callable";});

        //线程池用到参数
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix(
                "test-task-executor-").build();
        System.out.println("------------------------- 参数相关 ------------------------");


        ///jdk线程池，Executor、ExecutorService、ThreadPoolExecutor、ScheduledExecutorService、ScheduledThreadPoolExecutor
        //executor接口只有execute方法
        Executor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, queue);
        executor.execute(thread);
        //executor接口定义了submit方法，有返回值的方法
        ExecutorService executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, queue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(thread);
        Future<String> future = executorService.submit(callable);
        //构造方法都需要入参，定义线程池参数；核心线程数、最大线程数、存活时间、存活时间单位、任务队列、线程工厂、拒绝策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, queue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            int index = i;
            threadPoolExecutor.execute( ()-> System.out.println("i:"+index+"execute!"));
            future = (Future<String>) threadPoolExecutor.submit(()-> System.out.println("i:"+index+"submit!"));
        }

        //继承了ExecutorService，核心方法schedule()、scheduleAtFixedRate周期、scheduleWithFixedDelay延迟，后两个相当于定时
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        //继承了ThreadPoolExecutor，实现了ScheduledExecutorService
        //核心方法schedule()，其他方法和ThreadPoolExecutor相同execute()、submit()方法
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                new ScheduledThreadPoolExecutor(CORE_POOL_SIZE, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        Future<String> stringFuture = scheduledThreadPoolExecutor.schedule(callable, DELAY, TimeUnit.MILLISECONDS);
        try {
            stringFuture.get();
        }catch (Exception e){ }
        scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, DELAY, PERIOD, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(runnable, DELAY, PERIOD, TimeUnit.MILLISECONDS);

        //线程池工具类，可以获取定义好的线程池，阿里规定禁用，因为线程是稀缺资源，应该自己合理的去配置，不应该通过固定的默认值来给所有业务用
        executorService =  Executors.newCachedThreadPool();
        scheduledExecutorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        //Executors工具类的四个方法
        Executors.newSingleThreadExecutor();// 包含单个线程的线程池
        Executors.newFixedThreadPool(MAXIMUM_POOL_SIZE);// 固定线程数量的线程池
        Executors.newCachedThreadPool();// 线程数量可伸缩的线程池 (任务多就创建多一点线程，任务少就创建少一点线程)
        Executors.newScheduledThreadPool(CORE_POOL_SIZE);//ScheduledThreadPool是一个固定大小的线程池，与FixedThreadPool类似，执行的任务是定时执行。

        ///spring线程池，TaskExecutor、AsyncTaskExecutor、ThreadPoolTaskExecutor、TaskScheduler、ThreadPoolTaskScheduler、SimpleAsyncTaskExecutor
        //继承了Executor，是一个函数式接口，只有execute方法
        TaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.execute(thread);
        //定义了submit方法，有返回值的方法
        AsyncTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        try {
            String str = asyncTaskExecutor.submit(callable).get();
        }catch (Exception e){}
        //定义了延迟类的所有方法
        TaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        //有默认值，可以通过set来修改默认值
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.execute(thread);
        future = threadPoolTaskExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        //@Async注解默认使用的线程池
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        System.out.println("------------------------- 线程池相关 ------------------------");


        ///定时任务
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

            }
        };
        timer.schedule(timerTask, 1000);
        System.out.println("------------------------- 定时任务相关 ------------------------");
    }
}
