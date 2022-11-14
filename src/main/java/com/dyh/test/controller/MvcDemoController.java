package com.dyh.test.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description:Spring mvc查看源码（控制器三种方式：继承Controller、注解、）
 *              当前方式是 继承Controller
 * author: dyh
 * date: 2022/11/4 17:35
 */
public class MvcDemoController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest var1, HttpServletResponse var2) throws Exception{
        return null;
    }
}
