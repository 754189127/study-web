package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  * 发布订阅消息消费者B
 * @author wguo
 * @date 2019/02/20 16:07
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiveB {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanout Receiver B  : " + message);
    }
}
