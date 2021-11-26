package com.dyh.test.controller;

import com.dyh.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: demo通用controller
 * author: dyh
 * date: 2021/9/26 15:56
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("get")
    public void get(){

    }

    @GetMapping("/testAfterReturning")
    public String testAfterReturning(){
        return demoService.testAfterReturning("aaa","bbb");
    }
}
