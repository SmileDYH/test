package com.dyh.test.lock;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description: 锁main方法
 * author: dyh
 * date: 2021/6/30 16:22
 */
public class LockMain {


    public static void main(String[] args) {
        System.out.println("main开始");
        Mutex mutex = new Mutex();
        for (int i=0; i<2; i++){
            new Thread(() -> {

                System.out.println("锁前isLocked--->"+mutex.isLocked()+" "+Thread.currentThread().getName());
                mutex.lock();
                System.out.println("锁后isLocked--->"+mutex.isLocked()+" "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);//睡眠
                }catch (Exception e){}
//                mutex.unlock();
//                System.out.println("释放后isLocked--->"+mutex.isLocked()+" "+Thread.currentThread().getName());
            },String.valueOf("线程名"+i)).start();
        }

        System.out.println("main结束");
    }
}
