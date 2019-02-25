package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wguo
 * @date 2019/02/20 16:35
 */
@Component
@RabbitListener(queues = "work")
public class WorkReceiver1 {

    @RabbitHandler
    private void process(String message){
        System.out.println("WorkReceiver1 接收到消息  : " + message);
    }
}
