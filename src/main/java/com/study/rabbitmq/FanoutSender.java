package com.study.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发布订阅消息生产者
 * 生产者将消息不是直接发送到队列，而是发送到X交换机，然后由交换机发送给两个队列，两个消费者各自监听一个队列，来消费消息。
 * 这种方式实现同一个消息被多个消费者消费。工作模式是同一个消息只能有一个消费者。
 * @author wguo
 * @date 2019/02/20 16:06
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange","", context);
    }
}
