package com.dyh.test.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * description: jsonDemo
 * author: dyh
 * date: 2022/3/30 16:20
 */
public class JsonDemo {

    public static void main(String[] args) {

        printFastjson();


    }

    //alibaba.fastjson
    private static void printFastjson(){
        Map<String, Object> map = new HashMap<>();
        map.put("taskShareId", "a");
        map.put("teacherId", "b");

        String mqMessage = JSON.toJSONString(map);
        JSONObject mapa = (JSONObject)JSON.parse(mqMessage);
        System.out.println(mqMessage);
        System.out.println(mapa);
    }
}
