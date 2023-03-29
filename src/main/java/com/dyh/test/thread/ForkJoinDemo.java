package com.dyh.test.thread;

import java.util.concurrent.*;

/**
 * description: 分治框架（分而治之） - Fork/Join框架
 *              ForkJoinPool 是对线程池使用场景和功能上进行了一个补充
 * author: dyh
 * date: 2023/2/17 17:34
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        //ForkJoinPool 继承AbstractExecutorService，它又实现了ExecutorService，它的父类是Executor，体系就很清楚了，也是Executor线程池家族的
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //通用线程池，commonPool()静态方法，返回一个ForkJoinPool；静态代码块中被赋值(static{})，也就是初始化时候就赋值了，底层是调用了私有的有参构造函数(private)
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        //获取机器运行时可用的 CPU 核心数
        int cpuCore = Runtime.getRuntime().availableProcessors();
        System.out.println("cpuCore:" + cpuCore);
        System.out.println("------------------ cpuCore -----------------");

        //ForkJoinTask 实现了Future
        ForkJoinTask forkJoinTask = new ReturnTask();
        ReturnTask returnTask = new ReturnTask();
        VoidTask voidTask= new VoidTask();
        CallBackTask callBackTask= new CallBackTask();

        //ForkJoinPool执行方法execute()、submit()、invoke()
        forkJoinPool.invoke(voidTask);
        Long result = (Long)forkJoinPool.invoke(forkJoinTask);
//        forkJoinPool.invoke(callBackTask);//网上暂无完整的使用方法，证明用的很少
        System.out.println("result:" + result);
        System.out.println("------------------ invoke() -----------------");
        forkJoinPool.execute(()->{});// Runnable/ForkJoinTask
        forkJoinPool.execute(voidTask);
        forkJoinPool.submit(()->{return null;});// Runnable/Callable/ForkJoinTask
        Future<Long> future =  forkJoinPool.submit(returnTask);
        try {
           Long l =future.get();
           System.out.println("result1:" + l);
        }catch (Exception e){}
        System.out.println("------------------ execute()、submit() -----------------");

        //ManagedBlocker，如果存在i/o、线程间同步、sleep()等会造成线程长时间阻塞的情况，最好配合ManagedBlocker。
        //对io密集型的一种补充，可以做到自动感应，在cpu密集和io密集减切换，不用在创建线程池时候创建很多线程，造成cpu密集型时上下文切换从而浪费时间。
//        ForkJoinPool.ManagedBlocker
    }

    /**
     * ForkJoinTask一共有3个实现：
     * RecursiveTask：有返回值
     * RecursiveAction：无返回值
     * CountedCompleter：无返回值任务，完成任务后可以触发回调
     */
    private static class VoidTask extends RecursiveAction{
        @Override
        protected void compute() {
            System.out.println("RecursiveAction.compute()");
        }
    }

    private static class ReturnTask extends RecursiveTask<Long>{
        @Override
        protected Long compute() {
            System.out.println("RecursiveTask.compute()");
            return 1L;
        }
    }


    private static class CallBackTask extends CountedCompleter<Long> {
        @Override
        public void compute() {
            System.out.println("CountedCompleter.compute()");
        }
    }
}
