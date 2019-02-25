package com.study.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wguo
 * @date 2019/02/20 16:33
 */
@Component
public class WorkSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        for (int i=1;i<5;i++) {
            String context = i+"这是一条WorkSender消息!";
            System.out.println("WorkSender 开始发送消息 : " + context);
            this.amqpTemplate.convertAndSend("work", context);
        }
    }
}
