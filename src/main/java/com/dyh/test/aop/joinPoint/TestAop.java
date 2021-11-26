package com.dyh.test.aop.joinPoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    public static void main(String[] args) {
        //1、创建Spring的IOC的容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean.xml");

        //2、从IOC容器中获取bean的实例
        TargetClass targetClass = (TargetClass) ctx.getBean("targetClass");

        //3、使用bean
        String result = targetClass.joint("spring", "aop");
        System.out.println("result:" + result);
    }

//    @Test
//    public void testAOP() {
//
//    }
}