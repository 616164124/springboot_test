package com.example.demo.RabbitmqTest;

import com.example.demo.config.Rabbitmqconfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.Random;

/** 参考网址： https://blog.csdn.net/hellozpc/article/details/81436980 */
//     http://127.0.0.1:15672/
public class SendMessage {
  private static final String QUEUE_NAME = "test_queue_work";

  public static void main(String[] argv) throws Exception {
    while (true) {
      int i = 0;
      // 获取到连接以及mq通道
      Connection connection = Rabbitmqconfig.getConnection();
      // 从连接中创建通道
      Channel channel = connection.createChannel();
      // 声明（创建）队列
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);

      // 消息内容
      String message = "Hello World!" + (new Random().nextInt(100));
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

      System.out.println(" [x] Sent '" + message + "'");
      Thread.sleep(1000);
      // 关闭通道和连接
      channel.close();
      connection.close();
    }
  }
}
