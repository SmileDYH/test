package com.dyh.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类记录请求响应日志
 * 7个最常用的注解
 * @Aspect 把当前类声明为切面类
 */

@Aspect
@Component
@Slf4j
public class ApiLogAspect {

    //@Pointcut 切入点，指定切入点表达式
    @Pointcut("execution(public * com.dyh.test.controller..*.*(..))")
    public void log() {
        log.info("before cut1, do something");
    }

    //@Before 在...之前
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("before cut2, do something");
    }

    //@After 在...之后
    @After("log()")
    public void doAfter() {
        log.info("before cut3, do something");
    }

    //@AfterReturning 在...之后，有返回值
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("before cut4, do something");
        this.printOptLog();
    }

    //@Around 环绕通知，前后都切，在@Before、@After之前执行
    //@AfterThrowing 异常通知，最最后执行

    /**
     * 打印日志方法
     */
    private void printOptLog() {
        log.info("before cut5, do something");
    }
}