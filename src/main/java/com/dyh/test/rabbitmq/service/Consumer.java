package com.dyh.test.rabbitmq.service;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * 优化版消费者
 * description: dyh
 * author: Administrator
 * date: 2021/3/29 0029 11:34
 */
public class Consumer {

    public static void consumeMessage(Channel channel) throws IOException{
        String queueName = "queueName";
        String consumerTag = "consumerTag";
        // 消息消费实例
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery (String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                System.out.println("消息处理body:"+new String(body, "UTF-8"));
                // 处理消息
            }
        };
        // 自动消息确认
        boolean autoAck = true;
        channel.basicConsume(queueName,autoAck,consumerTag,consumer);
    }

}
