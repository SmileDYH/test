package com.dyh.test;

import cn.hutool.extra.spring.SpringUtil;
import com.dyh.test.parent.ParentTest;
import com.dyh.test.utils.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class MyTest extends ParentTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test1(){
        System.out.println("hi test");
    }

    @Test
    public void redisTemplateTest(){
        System.out.println("redisTemplateTest");
        //存入数据
//        redisTemplate.opsForValue().set("name","lzj");
//        redisTemplate.opsForValue().set("namea","dyh");
        RedisUtils.setValue("nameb", 1);
        RedisUtils.setValue("namec", "dyh");
        System.out.println("nameb--->"+ RedisUtils.getValue("nameb"));
        //获取数据类型
        System.out.println("nameb--->"+ RedisUtils.getValue("nameb").getClass().toString());
    }

    @Test
    public void stringRedisTemplateTest(){
        System.out.println("stringRedisTemplateTest");
        StringRedisTemplate stringRedisTemplate = SpringUtil.getBean(StringRedisTemplate.class);
        //存入数据
        stringRedisTemplate.opsForValue().set("name1","dyh");
    }

}

