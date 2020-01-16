package com.example.demo.RabbitmqTest;

import com.example.demo.config.Rabbitmqconfig;
import com.rabbitmq.client.*;

import java.io.IOException;

public class RecMessage2 {

  private static final String QUEUE_NAME = "test_queue_work";

  public static void main(String[] argv) throws Exception {

    // 获取到连接以及mq通道
    Connection connection = Rabbitmqconfig.getConnection();
    Channel channel = connection.createChannel();

    // 声明队列
    /**
     * 参数明细 1 queue：队列名称 2 durable： 是否持久化，如果持久化，mq重启后队列还在 3 exclusive
     * ：是否独占连接，队列不再使用时是否自动删除此队列，如果connection 连接关闭队列则自动删除，如果将此参数设置true 可用于临时队列 的创建
     *
     * <p>4 autoDelete 自动删除，队列不再使用时是否自动删除此队列，如果将此参数和exclusive参数设置为true就可以实现临时队列（队列不用了就自动删除）
     *
     * <p>5 argument 参数，可以设置一个队列的扩展参数吗，比如可设置存活时间
     */

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);

    // 实现消费者方法
    DefaultConsumer defaultConsumer =
        new DefaultConsumer(channel) {
          /** 当接收到消息后此方法将被调用
           *
           *    consumerTag  消费者标签，用来标识消费者的，在监听队列时设置channel.basicConsume
           *
           *    envelope   信封，通过envelope
           *    properties  消息属性
           *    body    消息内容
           * */
          @Override
          public void handleDelivery(
              String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
              throws IOException {

            // 交换机
            String exchange = envelope.getExchange();
            // 消息id mq在channel中用来标识消息的id，可用于确认消息已接收
            long deliveryTag = envelope.getDeliveryTag();
            // 消息内容
            String s = new String(body, "utf-8");
            System.out.println("rec message" + s);
          }
        };

    // 同一时刻服务器只会发一条消息给消费者
    // channel.basicQos(1);

    // 定义队列的消费者
    QueueingConsumer consumer = new QueueingConsumer(channel);
    // 监听队列，false表示手动返回完成状态，true表示自动
    channel.basicConsume(QUEUE_NAME, true, consumer);

    // 获取消息
    while (true) {
      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
      String message = new String(delivery.getBody());
      System.out.println(" [y] Received '" + message + "'");
      // 休眠
      Thread.sleep(1000);
      // 返回确认状态，注释掉表示使用自动确认模式
      // channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
    }
  }
}
