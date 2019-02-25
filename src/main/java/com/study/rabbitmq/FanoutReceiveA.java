package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅消息消费者A
 * @author wguo
 * @date 2019/02/20 16:07
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiveA {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanout Receiver A  : " + message);
    }
}
