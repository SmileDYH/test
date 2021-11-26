package com.dyh.test.rabbitmq.common;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *  创建连接信道共用类，返回channel
 * description: dyh
 * author: Administrator
 * date: 2021/3/29 0029 11:29
 */
public class ShareChannel {

    public static Channel createChannel() throws Exception{

        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        // 设置RabbitMQ服务应用信息
        // 服务默认端口5672、安装启动后会默认有个账号guest、密码guest
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        // 实例化连接
        Connection connection = factory.newConnection();

        // 获取信道实例
        Channel channel = connection.createChannel();
        return channel;
    }

}
