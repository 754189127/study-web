package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wguo
 * @date 2019/02/20 16:21
 */
@Component
@RabbitListener(queues = "simple")
public class SimpleReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("simple Receiver接收到消息  : " + message);
    }
}
