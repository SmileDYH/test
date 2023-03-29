package com.dyh.test.thread;

import java.util.concurrent.*;

/**
 * description:异步执行器
 * author: dyh
 * date: 2023/3/1 17:11
 */
//public class ExecutorCompletionServiceDemo {
//
//    public static void main(String[] args) {
//        //接口
//        CompletionService;
//        //实现类，实现了CompletionService
//        ExecutorCompletionService;
//    }
//}
public class ExecutorCompletionServiceDemo {

    public static void main(String[] args) {

        //这里只是为了方便，真正项目中不要这样创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(() -> {
            System.out.println("执行任务1开始");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行任务1结束");
            return "任务1执行成功";
        });

        completionService.submit(() -> {
            System.out.println("执行任务2开始");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行任务2结束");
            return "任务2执行成功";
        });

        completionService.submit(() -> {
            System.out.println("执行任务3开始");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行任务3结束");
            return "任务3执行成功";
        });

        for (int i = 0; i < 3; i++) {
            try {
                String result = completionService.take().get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        executorService.shutdown();
    }
}

