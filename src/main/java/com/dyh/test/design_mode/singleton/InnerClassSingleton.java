package com.dyh.test.design_mode.singleton;

public class InnerClassSingleton {
    private static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        //防止反射攻击
        if (SingletonHolder.INSTANCE != null){
            throw new RuntimeException("单例不允许创建多个实例");
        }
    }

    public static final InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}