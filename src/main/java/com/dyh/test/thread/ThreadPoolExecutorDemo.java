package com.dyh.test.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * description:线程池 ThreadPoolExecutor Demo
 * author: dyh
 * date: 2023/2/20 14:28
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 10;
    private static final int MAXIMUM_POOL_SIZE = 100;
    private static final long KEEP_ALIVE_TIME = 1000;

    //main方法抛出了异常，要不然get()方法是需要捕获异常的
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        //线程运行
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable...");
            }
        };
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("callable...");
                return null;
            }
        };
        System.out.println("------------- 创建线程 --------------");


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
        System.out.println("------------- 队列、线程工厂 --------------");


        //executor接口只有execute方法，执行任务
        Executor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, queue);
        executor.execute(runnable);
        System.out.println("------------- Executor.execute() --------------");

        //executorService接口定义了submit方法，有返回值的方法
        ExecutorService executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, queue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(runnable);
        Future<String> future = executorService.submit(callable);
        Future stringFuture = executorService.submit(runnable, "测试是否返回该值");
        System.out.println("future:" + future);
        System.out.println("stringFuture:" + stringFuture.get());
        System.out.println("------------- ExecutorService.submit() --------------");

        //构造方法都需要入参，定义线程池参数；核心线程数、最大线程数、存活时间、存活时间单位、任务队列、线程工厂、拒绝策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, queue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            int index = i;
            threadPoolExecutor.execute( ()-> System.out.println("i"+index+":execute!"));
            Future future1 = threadPoolExecutor.submit(new RunnableSubmit());
            Future future2 = threadPoolExecutor.submit(new CallableSubmit());
            System.out.println("future1:" + future1.get());
            System.out.println("future2:" + future2.get());
            System.out.println("---------------------------");
        }
    }


    //匿名内部类，实现Runnable接口
    private static class RunnableSubmit implements Runnable{
        @Override
        public void run(){
            System.out.println("RunnableSubmit...");
        }
    }

    //匿名内部类，实现Callable接口
    private static class CallableSubmit implements Callable<String>{
        @Override
        public String call(){
            System.out.println("CallableSubmit...");
            return "CallableSubmit";
        }
    }
}
