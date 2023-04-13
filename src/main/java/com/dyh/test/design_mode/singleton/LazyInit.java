package com.dyh.test.design_mode.singleton;

import com.dyh.test.model.pojo.KAMBaseDto;

/**
 * 单例模式，双重检验锁，
 * description: dyh
 * author: Administrator
 * date: 2021/2/18 0018 17:34
 */
public class LazyInit {

    private static volatile KAMBaseDto resource;

    public KAMBaseDto getResource() {

        KAMBaseDto result = resource;

        if (result == null) {
            synchronized (this) {
                 result = resource;
                if (result == null) {
                    result = new KAMBaseDto();
                }
            }
        }
        return result;
    }
}
