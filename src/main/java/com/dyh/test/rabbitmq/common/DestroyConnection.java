package com.dyh.test.rabbitmq.common;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 销毁连接信道
 * description: dyh
 * author: Administrator
 * date: 2021/3/29 0029 11:40
 */
public class DestroyConnection {

    //Connection关闭等于关闭所有Channel，Channel是依赖于Connection的逻辑连接
    public static void destroyConnection(Connection connection, Channel channel) throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}
