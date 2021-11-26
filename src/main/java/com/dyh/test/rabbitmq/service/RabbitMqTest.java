package com.dyh.test.rabbitmq.service;

import com.dyh.test.common.A;
import com.dyh.test.rabbitmq.common.DestroyConnection;
import com.dyh.test.rabbitmq.common.ShareChannel;

/**
 * description: dyh
 * author: Administrator
 * date: 2021/3/29 0029 11:39
 */
public class RabbitMqTest {

    public static void main(String[] args) {
        try {
            byte[] message = "binding".getBytes();
            //启动生产者
            Producer.publishMessage(ShareChannel.createChannel(), message);
            //启动消费者
            while (true){
                Consumer.consumeMessage(ShareChannel.createChannel());
            }
            //关闭生产者连接
           // DestroyConnection.destroyConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
