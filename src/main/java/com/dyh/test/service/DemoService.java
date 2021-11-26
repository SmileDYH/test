package com.dyh.test.service;

import org.springframework.stereotype.Service;

/**
 * description: demo通用service
 * author: dyh
 * date: 2021/11/4 17:29
 */
@Service
public class DemoService {

    public String testAfterReturning(String a,String b) {
        System.out.println("testAfterReturning执行了！！！");
        return a+b;
    }
}
