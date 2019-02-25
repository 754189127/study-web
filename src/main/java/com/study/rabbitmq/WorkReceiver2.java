package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wguo
 * @date 2019/02/20 15:08
 */
@Component
@RabbitListener(queues = "work")
public class WorkReceiver2 {
    @RabbitHandler
    public void process(String message){
        System.out.println("WorkReceiver2 接收到消息  : " + message);
    }
}
