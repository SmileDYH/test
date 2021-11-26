package com.dyh.test.aop.afterReturning;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
@Aspect //指明一个切面
@Slf4j
public class LogAspect {

    //指明切入点
    @Pointcut(value = "execution(* com.dyh.test.service.DemoService.testAfterReturning(..))")
    public void testAfterReturing(){};

    @AfterReturning(pointcut = "testAfterReturing()")
    public void logTestAfterReturing(){
        System.out.println("测试AfterReturing---pointcut");
    }
    //可以直接使用切入表达式，指明切入点
    @AfterReturning(pointcut = "execution(* com.dyh.test.service.DemoService.testAfterReturning(..))")
    public void logTestAfterReturing2(){
        System.out.println("测试AfterReturing---value");
    }
    //value和pointcut参数效果一样，但当同时存在时，pointcut有效
    @AfterReturning(value = "testAfterReturing()")
    public void logTestAfterReturing3(){
        System.out.println("测试AfterReturing---value");
    }

    //returning能够将目标方法的返回值传到切面增强方法里
    // 声明rvt时指定的类型会限制目标方法必须返回指定类型(String)的值或没有返回值  
    // 此处将rvt的类型声明为Object，意味着对目标方法的返回值不加限制 
    @AfterReturning(pointcut = "testAfterReturing()",returning = "rvt")
    public void logTestAfterReturing4(String rvt){
        System.out.println("测试AfterReturning---returning:"+rvt);
    }
	//使用arg,能够将目标方法的参数传到切面增强方法里
    @AfterReturning(value = "testAfterReturing()&& args(a,b)",argNames = "a,b")
    public void logTestAfterReturning4(String a,String b){
        System.out.println("测试AfterReturing---arg:a="+a+";b="+b);
    }
	//使用argNames,能够调整参数顺序，默认值为arg中顺序
    @AfterReturning(value = "testAfterReturing()&& args(a,b)",argNames = "b,a")
    public void logTestAfterReturning5(String b,String a){
        System.out.println("测试AfterReturing---arg and argNames:b="+b+";a="+a);
    }
}

