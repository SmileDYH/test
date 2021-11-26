package com.dyh.test.rabbitmq.service;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * 优化版生产者
 * description: dyh
 * author: Administrator
 * date: 2021/3/29 0029 11:37
 */
public class Producer {

    public static void publishMessage(Channel channel, byte[] message) throws IOException {

        // 实例化消息服务组件
        String exchangeName = "exchangeName";
        String queueName = "queueName";
        String binding = "binding";
        String routingKey = binding;
        // 交换器持久化、自动删除
        boolean durable = true , autoDelete = false;
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT,durable,autoDelete,null);
        // 独占队列
        boolean exclusive = false;
        channel.queueDeclare(queueName,durable,exclusive,autoDelete,null);
        // 交换器、队列绑定
        channel.queueBind(queueName,exchangeName,binding);
        // 发送生产消息
        channel.basicPublish(exchangeName,routingKey,null,message);
        System.out.println("生产者发送成功！！！");
    }
}
