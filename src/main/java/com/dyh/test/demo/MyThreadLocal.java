package com.dyh.test.demo;

import java.util.concurrent.ConcurrentHashMap;

//记得加注解
public class MyThreadLocal {

    private final ConcurrentHashMap<Thread, Object> valueMap = new ConcurrentHashMap<>();

    public void set(Object newValue) {
        valueMap.put(Thread.currentThread(), newValue);

    }

    public Object get() {
        Thread currentThread = Thread.currentThread();

        Object o = valueMap.get(currentThread);

        if (o == null && !valueMap.containsKey(currentThread)) {

            o = initialValue();

            valueMap.put(currentThread, o);

        }

        return o;

    }

    public void remove() {
        valueMap.remove(Thread.currentThread());

    }

    public Object initialValue() {
        return null;
    }
}
        