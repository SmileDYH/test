package com.dyh.test.redis;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * description: redisTemplate测试类
 * author: dyh
 * date: 2022/1/26 14:03
 */
public class RedisTemplateTest {

//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;

    //需要注入，移到了单元测试里
    public static void main(String[] args) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate();
        //存入数据
        redisTemplate.opsForValue().set("name","lzj");

        StringRedisTemplate stringRedisTemplate = SpringUtil.getBean(StringRedisTemplate.class);
        //存入数据
        stringRedisTemplate.opsForValue().set("name1","dyh");
    }


}
